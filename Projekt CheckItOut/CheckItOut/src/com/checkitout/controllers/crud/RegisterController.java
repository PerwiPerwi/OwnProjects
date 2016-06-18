package com.checkitout.controllers.crud;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.service.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		UserService userService = new UserService();
		String username = firstUpperCase(req.getParameter("inputUsername"));
		String password = req.getParameter("inputPassword");
		String email = firstUpperCase(req.getParameter("inputEmail"));

		if (checkIfFieldsExistInDb(username, email, req)) {
			try {				
				userService.addUser(username, email, password);
				req.getRequestDispatcher("/login").forward(req, resp);
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				req.getRequestDispatcher("/exception").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			req.getRequestDispatcher("/exception").forward(req, resp);
		}
		req.getRequestDispatcher("WEB-INF/login.jsp");
	}

	private String firstUpperCase(String text) {
		String first = text.substring(0, 1).toUpperCase() + text.substring(1);
		return first;
	}

	private boolean checkIfFieldsExistInDb(String username, String email, HttpServletRequest req) {
		boolean result = false;
		int errorCounter = 0;
		UserService userService = new UserService();
		String tempUsernameFromDb = userService.checkIfUsernameExist(username);
		String tempEmailFromDb = userService.checkIfEmailExist(email);
		
		if (tempUsernameFromDb.equalsIgnoreCase(username)) {
			errorCounter++;
			String usernameError = "Username: "+username;
			req.getSession(true).setAttribute("usernameError",usernameError);
		}
		if (tempEmailFromDb.equalsIgnoreCase(email)) {
			errorCounter++;
			String emailError = "Email: "+email;
			req.getSession(true).setAttribute("emailError", emailError);

		}
		if (errorCounter > 0) {
			return result;
		}
		result = true;
		return result;
	}
}
