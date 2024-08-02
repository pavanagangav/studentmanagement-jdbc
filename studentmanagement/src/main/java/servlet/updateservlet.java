package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.studentdb;
import models.student;
import services.studentservice;
@WebServlet("/update")
public class updateservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("NAME");
		String email =req.getParameter("EMAIL");
		String branch =req.getParameter("BRANCH");
		String pinnumber =req.getParameter("PINNUMBER");
		student std=new student(name,email,branch,pinnumber);
		studentservice service=new studentservice(studentdb.conn());
		boolean f=service.updatestu(std);
		if(f) {
			resp.sendRedirect("welcome.jsp");
			
		}
		else {
			resp.sendRedirect("welcome.jsp");
		}
		
	}

}
