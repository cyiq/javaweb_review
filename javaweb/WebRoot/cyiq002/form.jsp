<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>form</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    cyiq002/form.jsp<br>
    <form method="get" action="/javaweb/requestCN">
    	<input type="text" name="name"/> <br/>
    	<input type="password" name="psw"><br/>
    	<input type="checkbox" name="love" value="啊啊"/>啊啊<br/>
    	<input type="checkbox" name="love" value="宝宝"/>宝宝<br/>
    	<input type="checkbox" name="love" value="猜猜"/>猜猜<br/>
    	<input type="submit"/>
    </form>
  </body>
</html>
