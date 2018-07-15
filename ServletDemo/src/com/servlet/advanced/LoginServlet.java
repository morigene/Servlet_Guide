package com.servlet.advanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			 request.getRequestDispatcher("link.html").include(request, response);
			
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			
			if(username.equals("morigene")&& password.equals("morigene@123")) {
			
				 Cookie ck = new Cookie("username",username);
				 response.addCookie(ck);
				 out.print( " <br> <span style= 'color: #00DD00'> You are successful login </span>");
				 out.print( "<br> Welcome "+username);
				
	
				
			}else {
				
				out.println("<br> <span style='color:red'> Sorry your username or password is wrong! </span>");
				request.getRequestDispatcher("login.html").include(request, response);
				
			}
			
		}catch(Exception e) {
			
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
