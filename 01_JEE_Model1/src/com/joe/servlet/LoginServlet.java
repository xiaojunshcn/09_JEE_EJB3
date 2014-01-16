package com.joe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joe.biz.BizUser;
import com.joe.vo.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in LoginServlet.doPost()........");
		//设置HTTP响应的文档类型,此处为Text/html,如果更改为application\msword则设置为word文档格式  
		response.setContentType("text/html");  
		//设置响应所采用的编码方式  
		response.setCharacterEncoding("UTF8");  
		//取得参数username的值  
		String uname=request.getParameter("UserName");  
		String passwd=request.getParameter("Password");  
		
		System.out.println("uname:" + uname);
		System.out.println("passwd:" + passwd);
		
		UserVO user = new UserVO();
		user.setName(uname);
		user.setPassword(passwd);
		
		BizUser bu = new BizUser();
		boolean foundUserInDB = false;
		try {
			foundUserInDB = bu.checkUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("foundUserInDB:" + foundUserInDB);
		
		String forward;
		if (foundUserInDB) {
			//forward = "/login/success.jsp";	//it is OK here
			forward = "/ManageUserServlet";
		} else {
			forward = "/login/login.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);  
		rd.forward(request,response);  
	}
}