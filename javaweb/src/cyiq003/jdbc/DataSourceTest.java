package cyiq003.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

public class DataSourceTest {
	public static void main(String[] args) {
		Connection conn = DataSourceUtils.getCon();
		DataSource ds = DataSourceUtils.getDs();
		System.out.println(conn);
		System.out.println(ds);
	}
}
