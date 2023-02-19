package com.revature.poms.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/Home")
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called");
	}
	/**
	 * @see Servlet#destroy()
	 */
//	public void destroy() {
//		System.out.println("Destroy method");
//	}
	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = "admin@123";
		String password = "admin";
		
		String newEmail =  request.getParameter("email");
		String pass = request.getParameter("password");                
	       if(newEmail.trim().equals(email) && 
	          pass.trim().equals(password))
	       {   
	    	   HttpSession session = request.getSession();
	    	   
	    	   session.setAttribute("email", newEmail);
	    	   session.setAttribute("password",pass);
	          RequestDispatcher dis=request.getRequestDispatcher("home.jsp");          
	          dis.forward(request, response);  
	    	 
	       }     
	       else
	       {             
	          RequestDispatcher dis=request.getRequestDispatcher("");          
	          dis.include(request, response);                                
	       }   
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost called");
		doGet(request, response);
	}

}
