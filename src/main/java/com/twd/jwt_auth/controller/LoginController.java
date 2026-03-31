package com.twd.jwt_auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twd.jwt_auth.dao.UserDaoImpl;
import com.twd.jwt_auth.util.Jwtutil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDaoImpl userDao = new UserDaoImpl();

		boolean isValidUser = userDao.validateUser(username, password);
		if (isValidUser) {
			String token = Jwtutil.generateToken(username);
			System.out.println("Username : " + username);
			System.out.println("Token : " + token);
			HttpSession session = request.getSession();
			session.setAttribute("token", token);
			response.sendRedirect("dashboard.jsp");
		} else {
			request.setAttribute("error", "Invalid username or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
