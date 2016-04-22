package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


/**
 * oracle数据库批量操作
 * @author cyiq
 */
public class OrclBatchTest {
	
	/**
	 * oracle batch : 	1937	(1000)
	 * 					6229	(10000)
	 */
	@Test
	public void testStatementBatch() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getOrclConn();
		try {
			stmt = conn.createStatement();
			for(int i=0;i<10000;i++) {
				String sql = "INSERT INTO users(id,NAME,age) VALUES(2,'t',1)";
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			System.out.println("mysql statement batch time="+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, null);
		}
	}
	
	/**
	 * 
	 * oracle preparedstatement batch time=	1441	(1000)
	 * 										1602	(10000)
	 * 										1954	(100000)
	 * 										5495	(1000000)
	 */
	@Test
	public void testPreparedStatementBatch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getOrclConn();
		String sql = "INSERT INTO users(id,NAME,age) VALUES(2,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<1000;i++) {
				pstmt.setString(1, "t");
				pstmt.setInt(2, 1);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("mysql preparedstatement batch time="+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pstmt, null);
		}
	}
	
	/**
	 * oracle Statement time 	2412	(1000)
	 * 							6352	(10000)
	 */
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getOrclConn();
		
		try {
			stmt = conn.createStatement();
			for(int i=0;i<10000;i++) {
				String sql = "INSERT INTO users(id,NAME,age) VALUES(2,'t',1)";
				stmt.executeUpdate(sql);
			}
			System.out.println("mysql Statement time"+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, null);
		}
		
		
	}
}
