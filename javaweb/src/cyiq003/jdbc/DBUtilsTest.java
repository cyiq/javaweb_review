package cyiq003.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

public class DBUtilsTest {
	@Test
	public void update(){
		QueryRunner query = new QueryRunner(DataSourceUtils.getDs());
		//query.update("insert into users(name,email,brith) values('Jack','w@w.com','1900-09-08')");
		//这两种方式都可以
		try {
			query.update("insert into users(name,email,birth) values(?,?,?)",
				new Object[]{"Rose","w@125.com",new Date()});
//			query.update("delete from users where name=?","Rose");
//			query.update("update users set name=? ",new Object[]{"Jhon"});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void query(){
		QueryRunner query = new QueryRunner(DataSourceUtils.getDs());
		List<Map<String, Object>> list;
		try {
			list = query.query("select * from users",//以下使用了一个内部类
			new ResultSetHandler<List<Map<String,Object>>>(){
			public List<Map<String,Object>> handle(ResultSet rs) throws SQLException {
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				while(rs.next()){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name",rs.getString("name"));
					map.put("email",rs.getString("email"));
					map.put("brith",rs.getString("birth"));
					list.add(map);
				}
				for(Map<String,Object> t : list){
					System.out.println(t);
				}
				return list;
			}
			 });
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
