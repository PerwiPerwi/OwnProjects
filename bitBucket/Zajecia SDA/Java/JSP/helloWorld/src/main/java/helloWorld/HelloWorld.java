package helloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

//@WebServlet(name = "HelloWorld", value = "/hello")
public class HelloWorld extends HttpServlet {

	private String who;
	private int count;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		who = config.getInitParameter("who");
		//count = Integer.parseInt(config.getInitParameter("count"));
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count2 = Integer.parseInt(getServletConfig().getInitParameter("count"));
		PrintWriter pw = response.getWriter();
		for (int i = count2; i != 0; i--) {
			pw.println("Hello! " + who + " World"+"<br/>");
		}

	}

}
