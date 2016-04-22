package cyiq002.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestCNTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		if(name!=null){
//			name = URLDecoder.decode(name, "UTF-8");
//			System.out.println(name);
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");		//更换编码方式
			System.out.println(name);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		String[] love = request.getParameterValues("love");
		System.out.println(name+":"+psw);
		for(String l:love){
			System.out.println(l);
		}
	}

}
