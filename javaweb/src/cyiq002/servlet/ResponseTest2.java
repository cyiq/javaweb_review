package cyiq002.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseTest2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=UTF-8");
		//使用字符流
		//获取字符流
		PrintWriter out = resp.getWriter();
		//准备数据
		String str = "啊啊";
		//写入流
		out.print(str);
		out.print("<br/>");
		out.print(req.getAttribute("aaa"));
		out.close();
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
