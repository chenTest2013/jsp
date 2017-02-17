<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
//request.setCharacterEncoding("UTF-8");
//response.setCharacterEncoding("UTF-8");

String method=request.getMethod();
//解决中文乱码的问题
//String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");
String name=request.getParameter("name");
String url=request.getParameter("url");

System.out.println("name1:"+name+"\nurl1:"+url+"\nmethod1:"+method);

Enumeration<String> paramNames=request.getParameterNames();
while(paramNames.hasMoreElements()){
	String paramName = (String)paramNames.nextElement();
	String paramValue = request.getParameter(paramName);
	System.out.println(paramName+":"+paramValue);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>cjava.cn</title>
</head>
<body>
<h1>使用 <%=method %> 方法读取数据</h1>
<ul>
<li><p><b>站点名:</b>

   <%= name%>
</p></li>
<li><p><b>网址:</b>
   <%= url%>
</p></li>
</ul>
</body>
</html>