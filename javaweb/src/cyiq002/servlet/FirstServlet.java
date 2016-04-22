package cyiq002.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("服务器已加载firstServlet");
		System.out.println(config.getInitParameter("initParam"));
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		if(req.getMethod()=="GET"){
			System.out.println("get方法:");
			Enumeration<String> params = req.getParameterNames();
			while(params.hasMoreElements()){
				String name = params.nextElement();
				System.out.println(name+":"+req.getParameter(name));
			}
		}
		if(req.getMethod()=="POST"){
			System.out.println("post方法:");
			Enumeration<String> params = req.getParameterNames();
			while(params.hasMoreElements()){
				String name = params.nextElement();
				System.out.println(name+":"+req.getParameter(name));
			}
		}
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("firstServlet销毁了");
	}
	
}
