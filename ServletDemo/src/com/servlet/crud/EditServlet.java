package com.servlet.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String sid = request.getParameter("id");
		 int id = Integer.parseInt(sid);
		 
		 Emp e = new Emp();
		 
		 String name =request.getParameter("name");
		 String email = request.getParameter("email");
		 e.setId(id);
		 e.setName( name);
		 e.setEmail( email);
		
		 int status = EmpDao.UpdateEmployee(e);
		 if(status > 0) {
			 
			 JOptionPane.showMessageDialog(null, " It is ok, Record is successful updated ");
			 response.sendRedirect("wv");
		 }else {
			 
			 out.print(" Record is not update successful "+status);
		 }
		 
		 out.println( e.getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServlet
	 * Request request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
