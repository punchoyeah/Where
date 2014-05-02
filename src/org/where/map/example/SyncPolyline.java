package org.where.map.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class SyncPolyline extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Map<String, String> path = new HashMap<String, String>();
	
	protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        
		String method = request.getParameter("method");
		if ("add".equals(method)) {
	        path.put(request.getParameter("lat"), request.getParameter("lng"));
	        response.setContentType("application/json;charset=UTF-8");
	        response.getWriter().write("{\"result\": \"success\"}");
		} else if ("query".equals(method)) {
			JSONObject jsonObject = JSONObject.fromObject(path);
			System.out.println(jsonObject);
			response.getWriter().println(jsonObject);
		}     
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
    	doGet(request, response); 
    } 
}
