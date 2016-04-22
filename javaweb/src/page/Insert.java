package page;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;

import cyiq003.jdbc.DataSourceUtils;

public class Insert {
	public static void main(String[] args) throws Exception {
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?)";
		for(int i = 1; i <= 1000;i++){
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String num = "000"+i;
			num = num.substring(num.length()-4);
			uuid = num+"-"+uuid;
			run.update(sql,uuid,"jack"+i,i+"~"+i);
			System.out.println("done");
		}
	}
}
