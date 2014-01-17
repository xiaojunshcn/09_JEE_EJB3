<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,com.joe.ejb3.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	try{
		InitialContext ctx = new InitialContext();
		IHelloWorldLocal helloWorld = (IHelloWorldLocal) ctx.lookup("HelloWorldBean/local");
		out.println(helloWorld.sayHello("Local one"));
	} catch(Exception e) {
		out.println(e.getMessage());
	}
%>
</body>
</html>