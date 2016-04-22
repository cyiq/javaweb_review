package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据库设置不自动提交，加载事务，使得发生异常后可以回退
 * @author cyiq
 */
public class TransactionTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			String sql = "insert into user (name,age) values(?,?)";
			conn = JDBCUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			System.out.println("默认提交？"+conn.getAutoCommit());
			conn.setAutoCommit(false);
			System.out.println("默认提交？"+conn.getAutoCommit());
			pstmt.setString(1, "aaa");
			pstmt.setInt(2, 55);
			pstmt.execute();
			System.out.println(5/0);
			pstmt.setString(1, "bbb");
			pstmt.setInt(2, 66);
			pstmt.execute();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, pstmt, null);
		}
	}
}

