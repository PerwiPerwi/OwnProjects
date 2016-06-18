package com.checkitout.controllers.pictures;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebServlet("/pictureWriter")
public class PictureWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		updatePictureUrl(req);
		resp.sendRedirect("/CheckItOut/editView");
	}

	private String pictureWriter(HttpServletRequest request) throws ServletException, IOException {
		ServletContext test = getServletContext();
		String path = test.getResource("/profilePictures").getPath();
		String pictureName = "";
		if (ServletFileUpload.isMultipartContent(request)) {

			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(path + name));
						pictureName = name;
					}
				}

			} catch (Exception ex) {
				request.getRequestDispatcher("/exception");
				ex.printStackTrace();
			}
		}
		return pictureName;
	}

	private void updatePictureUrl(HttpServletRequest req) throws ServletException, IOException {
		User user = (User) req.getSession(false).getAttribute("user");
		String pictureUrl = pictureWriter(req);
		user.setPictureUrl(pictureUrl);
		UserService userService = new UserService();
		boolean result = userService.updatePictureUrl(user);
		User userForSession = (User) req.getSession(false).getAttribute("user");
		req.getSession(false).setAttribute("user", userForSession);

	}

}
