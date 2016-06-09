package com.checkitout.controllers.pictures;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/defaultPicture")
public class DefaultPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setDefaultPicture(req);
		resp.sendRedirect("/CheckItOut/editView");
	}
	private void setDefaultPicture(HttpServletRequest req){
		String pictureUrl = "standartProfilePicture.jpg";
		User user = (User)req.getSession(false).getAttribute("user");
		UserService userService = new UserService();
		user.setPictureUrl(pictureUrl);
		userService.setDefaultPicture(user);
		req.getSession(true).setAttribute("user", user);
	}
	
}
