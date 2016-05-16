package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class UpdateUserServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(AddUserServlet.class);
	
	UserDAO userDao = new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMsg = "";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		Integer userId = Integer.valueOf(id);
		if (null == userId) {
			errorMsg += "Nie podano parametru id.";
		}

		if (!errorMsg.isEmpty()) {
	//		log.error(errorMsg);
			request.setAttribute("_ERROR", errorMsg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.html");
			requestDispatcher.forward(request, response);
			return;
		}

		boolean result = userDao.updateUser(name, email, userId);
		if (!result) {
			//log.error("Problem z usunieciem usera o id=" + id);
			request.setAttribute("_ERROR", "Problem z aktualizacj¹ usera o id = " + userId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		request.setAttribute("_OK", "Zaaktualizowano usera o id = " + userId);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html");
		requestDispatcher.forward(request, response);
	}
	}
	
