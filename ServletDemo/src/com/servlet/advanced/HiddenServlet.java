package com.servlet.advanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenServlet
 */
@WebServlet("/HiddenServlet")
public class HiddenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenServlet() {
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
			 
			 String uname  = request.getParameter("username");
			 out.print( " Welcome "+uname + " <br>");
			 out.print("<form action='hw'>");
			 out.print("<input type='hidden' name='name' value='"+uname+"'>"); 
			 out.print("<br /> <input type='submit' value='go'>");
			 out.print("</form>");
			 
			 
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
