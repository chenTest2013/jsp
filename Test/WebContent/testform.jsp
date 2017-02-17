<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% //request.setCharacterEncoding("UTF-8");
       //response.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>cjava.cn</title>
</head>
<body>

<form action="main.jsp">
站点名: <input type="text" name="name">
<br />
网址: <input type="text" name="url" />
<input type="checkbox" name="google" checked="checked" /> Google
<input type="checkbox" name="runoob"  /> cjavacn
<input type="checkbox" name="taobao" checked="checked" />淘宝
<input type="submit" value="get提交" />

<input type="submit" value="post提交" formmethod="post" placeholder="post submit" />
</form>

</body>
</html>