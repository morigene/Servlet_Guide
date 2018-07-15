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
 * Servlet implementation class LoginSession
 */
@WebServlet("/LoginSession")
public class LoginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSession() {
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
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			
			if(username.equals( "morigene") && password.equals("morigene@123")) {
		      out.println(" <br>");
		      out.println(" Welcome "+username);
		      HttpSession session =  request.getSession();
		      session.setAttribute("uname",username);
		      out.print("");
		      
				
			
			}else {
				
				out.println( " Sorry username or password is not correct");
				request.getRequestDispatcher("loginSession.html").include(request, response);
			}
			
		}catch(Exception e ){
			e.printStackTrace( );
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
