package com.checkitout.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/admin")
public class AdminPanelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers(null);
		req.setAttribute("users", users);
		req.getRequestDispatcher("WEB-INF/admin.jsp").forward(req, resp);
	}
}
