package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.UserDAO;
import com.mysql.jdbc.ResultSet;

public class UserChangepass extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
String uid=req.getParameter("uid");
	
	String oldpass=req.getParameter("oldpass");
	String npass=req.getParameter("npass");
	String rpass=req.getParameter("rpass");
	String chekcpass=null;
	RequestDispatcher rd=null;
	//System.out.println("Uid :"+uid+" old Pass :"+oldpass+" new :"+npass+" Rpass :"+rpass);
	
	ResultSet rs=UserDAO.userProfile(uid);
	try {
		while(rs.next())
		{
			chekcpass=rs.getString(3);	
			
		}
	
		if(oldpass.equals(chekcpass))
		{
			if(npass.equals(rpass))
			{
				boolean flag=UserDAO.userChangepass(uid, npass);
				
				if(flag)
				{
					rd=req.getRequestDispatcher("/res/jsp/user/uchangepass.jsp?no=4");
					rd.forward(req, resp);
				}
				
			}else
			{
				rd=req.getRequestDispatcher("/res/jsp/user/uchangepass.jsp?no=3");
				rd.forward(req, resp);	
			}
		}else
		{
			rd=req.getRequestDispatcher("/res/jsp/user/uchangepass.jsp?no=2");
			rd.forward(req, resp);
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
}
