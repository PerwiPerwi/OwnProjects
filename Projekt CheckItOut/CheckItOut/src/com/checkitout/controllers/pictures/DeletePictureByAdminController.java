package com.checkitout.controllers.pictures;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/deletePictureByAdmin")
public class DeletePictureByAdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		String pictureUrl = "standartProfilePicture.jpg";
		long userId = Long.parseLong(req.getParameter("user_id"));
		System.out.println(userId);
		User user = userService.getUserById(userId);
		user.setPictureUrl(pictureUrl);
		userService.setDefaultPicture(user);
		req.getRequestDispatcher("/updateByAdmin").forward(req, resp);
	}
}
