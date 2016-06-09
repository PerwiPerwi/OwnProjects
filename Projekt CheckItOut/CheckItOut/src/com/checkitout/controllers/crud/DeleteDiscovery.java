package com.checkitout.controllers.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.service.DiscoveryService;

@WebServlet("/deleteDiscovery")
public class DeleteDiscovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		long discoveryId = Long.parseLong(req.getParameter("discovery_id"));
		DiscoveryService discoveryService = new DiscoveryService();
		result = discoveryService.deleteDiscovery(discoveryId);
		if(result){
			req.getRequestDispatcher("/home").forward(req, resp);
		} else {
			req.getRequestDispatcher("/exception").forward(req, resp);
		}
	}
}
