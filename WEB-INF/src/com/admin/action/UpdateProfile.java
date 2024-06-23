package com.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;



public class UpdateProfile extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	
	
	String uid=req.getParameter("uid");
	String uname=req.getParameter("uname");
	
	
	String umail=req.getParameter("umail");
	String uphone=req.getParameter("uphone");
	String addr=req.getParameter("addr");
	System.out.println("update profile");
	
	boolean flag=AdminDAO.updateprofile(uid, uname,umail, uphone,addr);
	
	RequestDispatcher rd=null;
	rd=req.getRequestDispatcher("/res/jsp/admin/profile.jsp?no=2");
	rd.forward(req, resp);
	
}
}
