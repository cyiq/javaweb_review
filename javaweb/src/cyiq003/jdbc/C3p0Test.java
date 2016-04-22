package cyiq003.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Test {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource("itcast");
		Connection con = ds.getConnection();
		System.out.println(con);
		con.close();

	}
}
