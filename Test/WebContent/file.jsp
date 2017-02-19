<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%

    BufferedReader reader = new BufferedReader(new FileReader("D://job.txt"));

    String content = reader.readLine();

    reader.close();
    System.out.print(System.getProperty("file.encoding"));
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>read file</title>
</head>
<body>
    <%=content%>
</body>
</html>