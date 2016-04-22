package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DataSourceUtils {
	private DataSourceUtils(){
	}
	private static DataSource ds;
	static{
		try{
			Properties p = new Properties();
		p.load(DataSourceUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			ds = new BasicDataSourceFactory().createDataSource(p);
		}catch(Exception e){}
	}
	//返回一个唯一的连接
	public static Connection getCon(){
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {e.printStackTrace();}
		return con;
	}
	//提供一个方法返回DataSource
	public static DataSource getDs(){
		return ds;
	}
	public static DataSource getDataSource(){
		return ds;
	}
}
