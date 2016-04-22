package cyiq002.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author cyiq
 */
public class FowardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fowardServlet的get方法");
		request.setAttribute("aaa", "foward");
		//获取到 /resonse的servlet  输出的内容 
		//http://localhost:8787/javaweb/foward地址并没有发生变化
		request.getRequestDispatcher("/response2").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}
