package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcher
 */

public class RequestDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		/* ___________    Identify who login in index.html _________________  */
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<title> dispatcher </title>");
		String name = request.getParameter("fname");
		
		if(name.equals("origene")) {
			
		  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("wel");
		  rd.forward(request, response);
		}else {
			pw.println(" Sorry, Username or Password is not available" +name);
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.include(request, response);
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
