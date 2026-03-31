package com.twd.jwt_auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twd.jwt_auth.dao.UserDaoImpl;
import com.twd.jwt_auth.model.OperationResult;
import com.twd.jwt_auth.model.User;

public class RegisterServlet extends HttpServlet {
	OperationResult result  = new OperationResult();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		User user = new User();
		UserDaoImpl userDao = new UserDaoImpl();
		boolean status;
		String msg;

		if (!password.equals(confirmPassword)) {
			msg="Passwords do not match";
			status = false;
		    return;
		}
		else {
			user.setUsername(username);
			user.setPassword(confirmPassword);
			status = userDao.saveUser(user);
		}
		if (status == true) {
			result.setMessage("Registration Success");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
