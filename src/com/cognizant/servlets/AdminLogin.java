package com.cognizant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.dao.AdminDao;




@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		//if(email.equals("keyancse12@gmail.com")&&password.equals("karthik")){
		
		boolean status=AdminDao.validate(email, password);
		if(status){
			HttpSession session=request.getSession();
			
		
			session.setAttribute("admin","true");
			System.out.println(status);
			request.getRequestDispatcher("adminhome.html").include(request, response);
		}else{
			
			request.getRequestDispatcher("AdminLoginForm.html").include(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
 
}
