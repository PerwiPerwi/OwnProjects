package com.checkitout.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.checkitout.model.User;
import com.checkitout.service.UserService;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if (httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null) {
			saveUserInSession(httpReq);
			
		}
		chain.doFilter(request, response);

	}

	private void saveUserInSession(HttpServletRequest request) {
		UserService userService = new UserService();
		String username = request.getUserPrincipal().getName();
		boolean isAdmin = request.isUserInRole("admin");
		User userByUsername = userService.getUserByUsername(username);
		request.getSession(true).setAttribute("user", userByUsername);
		request.getSession(true).setAttribute("isAdmin", isAdmin);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

}
