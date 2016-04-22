package cyiq002.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<Cookie> cookies = new ArrayList<Cookie>(); 
		cookies.add(new Cookie("aaa","aaa"));
		cookies.add(new Cookie("bbb","bbb"));
		cookies.add(new Cookie("ccc","ccc"));
		cookies.add(new Cookie("ddd","ddd"));
		cookies.add(new Cookie("cn",URLEncoder.encode("哈哈哈哈哈哈","UTF-8")));
		for(Cookie c : cookies){
			response.addCookie(c);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}


}
