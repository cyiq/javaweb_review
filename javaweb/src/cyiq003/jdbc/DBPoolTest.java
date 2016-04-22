package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


public class DBPoolTest {
	public static void main(String[] args) throws SQLException {
		DBPool pool = new DBPool();
		Connection conn1 = pool.getConnection();
		System.out.println(conn1);
		Connection conn2 = pool.getConnection();
		System.out.println(conn2);
		Connection conn3 = pool.getConnection();
		System.out.println(conn3);
		conn3.close();
		Connection conn4 = pool.getConnection();
		System.out.println(conn4);
	}
}
