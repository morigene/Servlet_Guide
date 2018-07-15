package com.servlet.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hatari
 */
@WebServlet("/Hatari")
public class Hatari extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hatari() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 response.setContentType( "text/html");
	 PrintWriter out = response.getWriter();
	 
	 try {
			
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","morigene@123");
		 PreparedStatement pst = con.prepareStatement("INSERT INTO test(firstname, lastname) VALUES(?,?)");
		 pst.setString(1, " Innocent");
		 pst.setString(2, "Kamarade");
		 int status = pst.executeUpdate();
		 if(status > 0) {
		out.println( " ok ");
		 }else {
			 
			out.println( " Not ok ");
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
