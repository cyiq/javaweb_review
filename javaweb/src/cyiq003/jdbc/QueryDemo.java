package cyiq003.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import static cyiq003.jdbc.DataSourceUtils.*;
public class QueryDemo {
	
	@Test
	public void query9() throws Exception{
		QueryRunner run = new QueryRunner(getDataSource());
		String sql = "select * from contacts";
		List<Contact> cs =
				run.query(sql, 
				new ResultSetHandler<List<Contact>>(){
					@Override
					public List<Contact> handle(ResultSet rs)
							throws SQLException {
						List<Contact> list = new ArrayList<Contact>();
						while(rs.next()){
							Contact c = new Contact();
							c.setCid(rs.getString("cid"));
							c.setCname(rs.getString("cname"));
							c.setCtel(rs.getString("ctel"));
							list.add(c);
						}
						return list;
					}
				});
		System.out.println(">>>:"+cs);
	}
	
}
