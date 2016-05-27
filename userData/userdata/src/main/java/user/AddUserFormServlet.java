package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addUser.html")
public class AddUserFormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/addUser.jsp");
		requestDispatcher.include(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/addUser.jsp");
		requestDispatcher.include(request, response);
		System.out.println("Do Get ADD USER FROM SERVLET");
	}
}
