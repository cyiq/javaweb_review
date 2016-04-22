package cyiq002.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DurableCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("durable","durable");
		//设置cookie的有效时间   使会话级的cookie变为持久化cookie
		cookie.setMaxAge(60*60*6);	//存储6小时
		resp.addCookie(cookie);
	}
	
}
