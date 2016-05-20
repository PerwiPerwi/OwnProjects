package pl.sda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sdaServlet")
public class SdaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -492760907942531400L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		Logger log = Logger.getGlobal();
		log.log(Level.INFO, "info message");

		List<Long> lista = new ArrayList<>();

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 100000; i++) {
				lista.add(new Long(10));
			}
			lista.clear();
		}

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println(System.getProperty("jboss.node.name"));
		out.println("<h1> OK</h1>");
	}

}
