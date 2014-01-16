package com.joe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * something different from AutoCompleteServlet.
 * not dispatcher to a wordxml.jsp which contains all matched data.
 * it will filter data in servlet, and the destination page will use JSTL to generate xml data.
 * 
 * @author xiajun
 *
 */
public class AutoCompleteJSTLServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//user input string in the screen 
		String wordFromScreen = req.getParameter("word");
		
		//save it to request object
		req.setAttribute("word", wordFromScreen);
		
		List<String> words = new ArrayList<String>();
		words.add("absolute");
		words.add("anyone");
		words.add("anything");
		words.add("apple");
		words.add("abandon");
		words.add("breach");
		words.add("break");
		words.add("boolean");
		req.setAttribute("words", words);
		
		//filter data in jstlData.jsp using jstl taglib
		req.getRequestDispatcher("jstlData.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
