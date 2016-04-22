package page;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cyiq003.jdbc.DataSourceUtils;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//每页多少行
		int pageSize = 10;	
		//用户请求第几页
		int currentPage = 0;
		String page = request.getParameter("page");
		if(page==null || page.trim()==""){
			currentPage = 1;
		}else{
			try{
				currentPage = Integer.parseInt(page);
			}catch(Exception e){
				currentPage = 1;
			}
		}
		if(currentPage<1){
			currentPage = 1;
		}
		
		try{
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select count(*) from user";
			Object o = qr.query(sql, new ScalarHandler());
			//共多少行
			int rows = Integer.parseInt(o.toString());
			//分多少页
			int pageCount = (rows+(pageSize-1))/pageSize;
			if(currentPage>pageCount){
				currentPage=pageCount;
			}
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageCount", pageCount);
			//查询指定页面的数据
			int start = (currentPage-1)*pageSize;
			sql = "select * from user limit "+start+","+pageSize;
			List<Map<String,Object>> datas = qr.query(sql, new MapListHandler());
			request.setAttribute("datas", datas);
			
			//定义每个页面显示多少个页码
			int pageNum = 10;
			int startNo = 0;
			int endNo = 0;
			if(pageNum > pageCount){
				startNo = 1;
				endNo = pageCount;
			}else{
				if(currentPage <= pageNum/2){
					startNo = 1;
					endNo = pageNum;
				}else if(currentPage >= pageCount-(pageNum)/2){
					startNo = pageCount-(pageNum-1);
					endNo = pageCount;
				}else{
					startNo = currentPage-(pageNum/2 -1);
					endNo = startNo+(pageNum-1);
				}
				
			}
			request.setAttribute("startNo", startNo);
			request.setAttribute("endNo", endNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("/page/show.jsp").forward(request, response);
	}

}
