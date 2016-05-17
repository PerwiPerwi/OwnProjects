package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormServlet extends HttpServlet {
	
	private UserDAO userDAO = new UserDAO();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/update.jsp");
		requestDispatcher.forward(request, response);
		processRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/update.jsp");
		requestDispatcher.forward(request, response);
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", userDAO.getAllUser());

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/users.jsp");
		requestDispatcher.include(request, response);
	}

}
