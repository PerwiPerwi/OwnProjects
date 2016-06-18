package com.checkitout.controllers.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/update")
public class UpdateUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User userScope = (User) request.getSession(false).getAttribute("user");
		UserService userService = new UserService();
		User user = new User();
		String usernameUserScope = userScope.getUsername();
		String password = request.getParameter("inputPassword");
		String email = request.getParameter("inputEmail");
		if (checkIfEmailExist(request, email, usernameUserScope)) {
			user.setEmail(email);
			user.setPassword(password);
			user.setUsername(userScope.getUsername());
			user.setPictureUrl(userScope.getPictureUrl());
			userService.updateUserByUser(user, password);
			request.getSession(true).setAttribute("user", user);
			response.sendRedirect("/CheckItOut/editView");
		} else {

			request.getRequestDispatcher("/exception");
		}
	}

	private boolean checkIfEmailExist(HttpServletRequest req, String email, String username) {
		UserService userService = new UserService();
		boolean result = userService.mailExist(email, username);
		if (!result) {
			String emailError = "Email: " + email;
			req.getSession(true).setAttribute("emailError", emailError);
			return result;
		} else {
			result = true;
		}
		return result;
	}
}
