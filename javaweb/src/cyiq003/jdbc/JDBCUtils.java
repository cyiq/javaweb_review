package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;

import com.mysql.jdbc.Driver;


public class JDBCUtils {
	private static final String user = null;
	private static final String password = null;
	public static Connection getConn(){
		String url = "jdbc:mysql://localhost:3306/dbtest";
		Properties info = new Properties();
		info.setProperty("user","root");
		info.setProperty("password","cyiq");
		
		Connection conn = null;
		try {
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection(url,info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getOrclConn(){
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Properties info = new Properties();
		info.setProperty("user","jkdb");
		info.setProperty("password","1234");
		
		Connection conn = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(url,info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt, ResultSet rs){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(rs !=null){
							try {
								rs.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		
	}
}
