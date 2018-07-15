package com.servlet.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		  response.setContentType( " text/html");
		  PrintWriter out = response.getWriter();
		  
		 
		  
		  List<Emp> list = EmpDao.getAllEmployee();
		 
		  out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		  for(Emp e: list ) {
			  
		 out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName() + "</td><td>"+e.getEmail()+
				 "</td><td>"+e.getCountry()+"</td><td>"+e.getPassword()+
				 "</td><td>"+"<a href='te?id="+e.getId()+"'> Edit </a>"+"</td><td>"+"<a href='td?id="+e.getId()+"'>Delete</>");
			  
		  }
			out.print("</table>");
			
			
			out.close();
		  
		  
		  
		  
		 
		  
		  
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
