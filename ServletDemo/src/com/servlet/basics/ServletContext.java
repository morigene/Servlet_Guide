package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext
 */
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     
		
		   response.setContentType("text/html");
		   PrintWriter pw = response.getWriter();
		   
		   
		   
		  javax.servlet.ServletContext context = getServletContext();
		  Enumeration<String> e = context.getInitParameterNames();
		  
		  String ss = "";
		  while(e.hasMoreElements()) {
			  
			  ss=e.nextElement();
			  pw.println(" "+context.getInitParameter(ss) + " <br> ");
		  }
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
