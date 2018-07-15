package com.servlet.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	public static Connection getConnnection() {
		
		Connection con = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","morigene@123");
        	
        }catch(Exception e) {
        	
        	System.out.println( e);
        }
		return con;
	}
	
	
	public static int saveEmp(Emp e ) {
		
		int status = 0;
		
		try {
			
			Connection con = EmpDao.getConnnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO emp(name,password,email,country)VALUES(?,?,?,?)");
			pst.setString(1, e.getName());
			pst.setString(2, e.getPassword());
			pst.setString(3, e.getEmail());
			pst.setString(4, e.getCountry());
		    status =	pst.executeUpdate();
		    
		    pst.close();
		    con.close();
			
		} catch (Exception e2) {
		
			 System.out.println( e2);
		}
		
		
		return status;
		
	}
	
	public static int delete(int id ) {
		
		int status = 0 ; 
		
		 try {
			 
			 Connection con = EmpDao.getConnnection();
			 PreparedStatement pst = con.prepareStatement( "DELETE FROM emp WHERE id = ? ");
			 pst.setInt(1,id);
			 status = pst.executeUpdate();
			 pst.close();
			 con.close();
			 
			 
		 }catch(Exception sql) {
			 
		 }
		
		
		return status;
		
		
	}
	
	
	public static Emp getEmployeeById(int id) {
		
		 Emp employee = new Emp();
		     try {
		    	 
		    	 Connection con = EmpDao.getConnnection();
		    	 PreparedStatement pst = con.prepareStatement( " SELECT * FROM emp WHERE id =  ? ");
		    	 pst.setInt(1, id);
		    	 ResultSet rs = pst.executeQuery();
		         
		    	
		    	 employee.setName(rs.getString(2));
		    	 employee.setCountry(rs.getString(5));
		    	
		    	 con.close();
		    	 
		     }catch (Exception e) {
				// TODO: handle exception
			}
		   
		     return employee;
		
	}
	
	
	public static List<Emp> getAllEmployee() {

		        List<Emp> list = new ArrayList<Emp>();
		        
		        try {
		            Connection con = EmpDao.getConnnection();
			        PreparedStatement pst = con.prepareStatement( " SELECT * FROM emp ");
			        ResultSet rs = pst.executeQuery();
			        while(rs.next()) {
			        	Emp e = new Emp();
			        	e.setId(rs.getInt(1));
			        	e.setName( rs.getString(2));
			        	e.setEmail(rs.getString(4));
			        	e.setPassword(rs.getString(3));
			        	e.setCountry(rs.getString(5)); 	
			            list.add(e);
			        }
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
		        
		  
		   return list;
		
	}
	
      /*Update record from database */
	
	public static int UpdateEmployee(Emp e) {
		   
		int status = 0;
		
		try {
			Connection con = EmpDao.getConnnection();
			PreparedStatement pst = con.prepareStatement( "UPDATE emp SET name=?,email=? WHERE id=?");
			pst.setInt(1,e.getId());
			pst.setString(2, e.getName());
			pst.setString(4 , e.getEmail());
			status = pst.executeUpdate();
			con.close();
			
			 
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		
		
		return status ;
		  
		
	}
	
	

}
