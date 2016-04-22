package cyiq002.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
 * @author cyiq
 *
 */
public class ServletContextTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		System.out.println(context.getContextPath());	//   /javaweb
		System.out.println(context.getRealPath("/"));	//   E:\apache-tomcat-7.0.63\webapps\javaweb\
		context.setAttribute("", "");		//可用于servlet之间通信
	}
}
