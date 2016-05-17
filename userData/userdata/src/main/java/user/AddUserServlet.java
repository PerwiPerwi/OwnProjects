package user;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

//@Slf4j
public class AddUserServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(AddUserServlet.class);

	private UserDAO userDAO = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = "";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if (null == name || name.isEmpty()) {
			errorMsg += "Nie podano parametru name.";
		}

		if (null == email || email.isEmpty()) {
			errorMsg += "Nie podano parametru email.";
		}
		
		if (!errorMsg.isEmpty()) {
			log.error(errorMsg);
			request.setAttribute("_ERROR", errorMsg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adduser.html");
			requestDispatcher.forward(request, response);
			return;
		}

		boolean result = userDAO.addUser(name, email);
		if (!result) {
			log.error("Problem z dodaniem usera z name = " + name +" i mail = " + email);
			request.setAttribute("_ERROR", "Problem z dodaniem usera o name=" + name+" z mailem"+email);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		request.setAttribute("_OK", "Dodano usera o name = " + name + "i mail = "+email);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/users.html");
		requestDispatcher.forward(request, response);
	}
}
