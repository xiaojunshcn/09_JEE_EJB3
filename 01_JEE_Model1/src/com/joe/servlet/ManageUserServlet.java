package com.joe.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joe.biz.BizUser;
import com.joe.vo.UserVO;

/**
 * Servlet implementation class ManageUserServlet
 */
public class ManageUserServlet extends HttpServlet {
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
		// to list all users
		System.out.println("in ManageUserServlet.doPost()...........");
		BizUser bu = new BizUser();
		List<UserVO> users = null;
		try {
			users = bu.retrieveAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users == null) {
			System.out.println("no user found");
		} else {
			System.out.println("users.size():" + users.size());
		}
		
		String forward = "/user/list.jsp";
		
		request.setAttribute("ALL_USERS_FROM_DB", users);
		RequestDispatcher rd=request.getRequestDispatcher(forward);  
		rd.forward(request,response);
	}

}
