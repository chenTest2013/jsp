<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
 	// 获取session创建时间
    Date createTime = new Date(session.getCreationTime());
    // 获取最后访问页面的时间
    Date lastAccessTime = new Date(session.getLastAccessedTime());
    int visitCount = 0;
    String visitCountKey = "visitCount";
    String userIDKey = "userID";
    String userID = "ABCD";
    if(session.isNew()){
        session.setAttribute(userIDKey, userID);
        session.setAttribute(visitCountKey,  visitCount);
    }else{
       visitCount = (Integer)session.getAttribute(visitCountKey);
 	   visitCount += 1;
 	   //userID = (String)session.getAttribute(userIDKey);
 	   session.setAttribute(visitCountKey,  visitCount);
    }
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session</title>
</head>
<body>
<% out.print( session.getId()+"<br/>"); %>
<% out.print(createTime+"<br/>"); %>
<% out.print(lastAccessTime+"<br/>"); %>
<% out.print(userID+"<br/>"); %>
<% out.print(visitCount+"<br/>"); %>
<% out.print(session.getMaxInactiveInterval()+"<br/>"); %>
<% out.print(System.getProperty("java.io.tmpdir")+"<br/>"); %>

 
</body>
</html>