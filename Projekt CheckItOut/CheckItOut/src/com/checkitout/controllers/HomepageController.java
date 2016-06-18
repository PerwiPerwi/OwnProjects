package com.checkitout.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.Discovery;
import com.checkitout.service.DiscoveryService;

@WebServlet("/home")
public class HomepageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		saveDiscovieresInRequest(req);
		setSystemPath(req);
		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	}

	private void saveDiscovieresInRequest(HttpServletRequest request) {
		DiscoveryService discoveryService = new DiscoveryService();
		List<Discovery> allDiscoveries = discoveryService.getAllDiscoveries(new Comparator<Discovery>() {


			public int compare(Discovery o1, Discovery o2) {
				int discovery1Vote = o1.getUpVote() - o1.getDownVote();
				int discovery2Vote = o2.getUpVote() - o2.getDownVote();
				if (discovery1Vote > discovery2Vote) {
					return -1;
				} else if (discovery1Vote < discovery2Vote) {
					return 1;
				}
				return 0;
			}
		});

		request.setAttribute("discoveries", allDiscoveries);
	}
	private void setSystemPath(HttpServletRequest request) throws MalformedURLException{
		ServletContext test = getServletContext();
    	String path = test.getResource("/META-INF").getPath();
    	String systemPath = getSystemPath(path);
    	request.getSession(true).setAttribute("systemPath", systemPath);
	}

	private String getSystemPath(String path){
    	int counter = 0;
    	String systemPath = "";
    	for (int i = path.length(); i != 0; i--){
    		if(path.charAt(i-1) == '/'){
    			counter++;
    			if(counter == 4){
    				systemPath = path.substring(0,i);
    				break;
    			}
    		}
    	}
    	
    	return systemPath;
    }
}
