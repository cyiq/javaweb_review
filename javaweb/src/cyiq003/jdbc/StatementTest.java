package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;



public class StatementTest {
	@Test
	public void insert(){
		Connection conn = JDBCUtils.getConn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "insert into user (name,age) values('abc',22)";
			stmt.execute(sql);
			JDBCUtils.close(conn, stmt,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void update(){
		Connection conn = JDBCUtils.getConn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "update user set name='aaa', age=11 where id=1";
			stmt.executeUpdate(sql);
			JDBCUtils.close(conn, stmt,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void select(){
		Connection conn = JDBCUtils.getConn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "select * from user where id=2";
			ResultSet rs = stmt.executeQuery(sql);
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
			JDBCUtils.close(conn, stmt,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		Connection conn = JDBCUtils.getConn();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "delete from user where id=1";
			stmt.execute(sql);
			JDBCUtils.close(conn, stmt ,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
