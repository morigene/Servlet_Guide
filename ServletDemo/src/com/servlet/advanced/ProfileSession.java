package com.servlet.advanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileSession
 */
@WebServlet("/ProfileSession")
public class ProfileSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		
    		request.getRequestDispatcher("linkForSession.html").include(request, response);
    	
    		HttpSession session  = request.getSession(false);
            if(session!= null) {
            	String name = (String) session.getAttribute("uname");
            	out.print( "<br />");
            	out.print( " Hey, "+name + " Welcome to RRA");
            	
            }else {
            	out.print( " <br />"+ " <hr >");
            	out.print( " <span style ='color:red'>"+" Login first Please "+ "</span>");
            	request.getRequestDispatcher("loginSession.html").include(request, response);
            }
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
