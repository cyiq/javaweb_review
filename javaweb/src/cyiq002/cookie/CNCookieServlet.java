package cyiq002.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CNCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies){
			if(c.getName().equals("cn")){
				String value = URLDecoder.decode(c.getValue(), "UTF-8");
				System.out.println(value);
			}
		}
		String data = "中文";
		data = URLEncoder.encode(data, "UTF-8");
		Cookie cookie = new Cookie("cn",data);
		response.addCookie(cookie);
	}

}
