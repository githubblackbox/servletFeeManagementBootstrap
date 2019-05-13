package com.cognizant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.beans.AdminBean;
import com.cognizant.dao.AdminDao;



@WebServlet("/AdminRegister")
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminRegister() {
        super();
  
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String city=request.getParameter("city");
		String contact=request.getParameter("contact");
		AdminBean bean=new AdminBean(name, email, password, city, contact);
		int status=AdminDao.save(bean);

		request.getRequestDispatcher("index.html").include(request, response);
		
	
	}




}
