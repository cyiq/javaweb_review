package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
/**
 * mysql数据库批量数据操作
 * @author cyiq
 */
public class BatchTest {
	
	/**
	 * batch : 37526
	 */
	@Test
	public void testStatementBatch() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConn();
		try {
			stmt = conn.createStatement();
			for(int i=0;i<1000;i++) {
				String sql = "INSERT INTO user(NAME,age) VALUES('t',1)";
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
	 * mysql preparedstatement batch time=36629
	 */
	@Test
	public void testPreparedStatementBatch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConn();
		String sql = "INSERT INTO user(NAME,age) VALUES(?,?)";
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
	 * mysql Statement time 33597
	 */
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConn();
		
		try {
			stmt = conn.createStatement();
			for(int i=0;i<1000;i++) {
				String sql = "INSERT INTO user(NAME,age) VALUES('t',1)";
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
