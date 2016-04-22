package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.junit.Test;

public class PreparedStatementTest {
	@Test
	public void insert(){
		Connection conn = JDBCUtils.getConn();
		PreparedStatement pstmt;
		try {
			String sql = "insert into user (name,age) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"pppp");
			pstmt.setInt(2, 6);
			pstmt.execute();
			JDBCUtils.close(conn, pstmt,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void update(){
		Connection conn = JDBCUtils.getConn();
		PreparedStatement pstmt;
		try {
			String sql = "update user set name=?, age=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "bbb");
			pstmt.setInt(2, 233);
			pstmt.setInt(3, 2);
			pstmt.executeUpdate();
			JDBCUtils.close(conn, pstmt,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void select(){
		Connection conn = JDBCUtils.getConn();
		PreparedStatement pstmt;
		try {
			String sql = "select * from user where id<?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id+":"+name+"-"+age);
				id = rs.getInt("id");
				name = rs.getString("name");
				age = rs.getInt("age");
				System.out.println(id+":"+name+"-"+age);
			}
			JDBCUtils.close(conn, pstmt,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		Connection conn = JDBCUtils.getConn();
		PreparedStatement pstmt;
		try {
			String sql = "delete from user where id<?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 3);
			pstmt.execute();
			JDBCUtils.close(conn, pstmt ,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
