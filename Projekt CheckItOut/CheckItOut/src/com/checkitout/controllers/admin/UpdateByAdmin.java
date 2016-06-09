package com.checkitout.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/updateByAdmin")
public class UpdateByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long userId = Long.parseLong(req.getParameter("user_id"));
		UserService userService = new UserService();
		User user = userService.getUserById(userId);
		String username = user.getUsername();

		req.getSession(true).setAttribute("userForUpdate", user);
		// req.getSession(true).setAttribute("userRole", userRole);
		req.getRequestDispatcher("WEB-INF/updateByAdmin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		User user = (User) req.getSession(false).getAttribute("userForUpdate");
		String username = user.getUsername();
		String email = req.getParameter("inputEmail");
		String role = req.getParameter("userRole");
		if (checkIfEmailExist(req, email, username)) {
			user.setEmail(email);
			user.setRole(role);
			userService.updateRole(role, username);
			userService.updateUserByAdmin(user);
		} else {
			req.getRequestDispatcher("/exception").forward(req, resp);
		}
		resp.sendRedirect("/CheckItOut/admin");
		
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
