package cyiq003.jdbc;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;


public class DBPool{
	//声明一个池管理对象
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	//在初始化这个DataSource的子类时在构造方法设置多个连接
	public DBPool(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///dbtest";
			for(int i=0;i<3;i++){
				final Connection con = DriverManager.getConnection(url,"root","cyiq");
				Object proxyedConn =
				Proxy.newProxyInstance(DBPool.class.getClassLoader(),
				new Class[]{Connection.class},
				new InvocationHandler(){
				public Object invoke(Object proxyedConnection, Method method, Object[] args)
										throws Throwable {
						if(method.getName().equals("close")){
							synchronized (pool) {
								pool.addLast((Connection) proxyedConnection);
								pool.notify();
							}
							return null;
						}
						//目标方法的返回值
						Object returnValue=method.invoke(con, args);
						return returnValue;
					}
	
				});
				pool.add((Connection) proxyedConn);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	public Connection getConnection() throws SQLException {
	synchronized (pool) {
		if(pool.size()==0){
			try {
				pool.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return getConnection();
		}
		Connection con = pool.removeFirst();
		System.err.println("size:"+pool.size());
		return con;
	}
}

}
