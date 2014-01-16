<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="com.joe.vo.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	list all users
	<br/>
	<%
		List<UserVO> users = (List<UserVO>)request.getAttribute("ALL_USERS_FROM_DB");
		if(users!=null) { 
			System.out.println("in /user/list.jsp,  users.size():" + users.size());
		}
		
		for (UserVO vo:users) {
	%>
			用户名: <%=vo.getName() %> , 密码： <%=vo.getPassword() %> <br/>
	<% 
		} //end of for loop
	%>
</body>
</html>