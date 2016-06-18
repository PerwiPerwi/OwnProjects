package com.checkitout.controllers.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.service.UserService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		long userId = Long.parseLong(req.getParameter("user_id"));
		userService.deleteUser(userId);
		if ((Boolean) req.getSession(true).getAttribute("isAdmin")) {
			req.getRequestDispatcher("admin").forward(req, resp);
		} else {
			req.getSession().invalidate();
			resp.sendRedirect("home");
		}
	}
}
