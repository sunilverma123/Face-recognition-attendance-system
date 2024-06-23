package com.admin.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;




public class Changepass extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	String uid=req.getParameter("uid");
	
	String oldpass=req.getParameter("oldpass");
	String npass=req.getParameter("npass");
	String rpass=req.getParameter("rpass");
	String chekcpass=null;
	RequestDispatcher rd=null;
	
	ResultSet rs=AdminDAO.profile(uid);
	try {
		while(rs.next())
		{
			chekcpass=rs.getString(2);	
			
		}
		
		
		if(oldpass.equals(chekcpass))
		{
			if(npass.equals(rpass))
			{
				boolean flag=AdminDAO.Changepass(uid, npass);
				
				if(flag)
				{
					rd=req.getRequestDispatcher("/res/jsp/admin/changepass.jsp?no=4");
					rd.forward(req, resp);
				}
				
			}else
			{
				rd=req.getRequestDispatcher("/res/jsp/admin/changepass.jsp?no=3");
				rd.forward(req, resp);	
			}
		}else
		{
			rd=req.getRequestDispatcher("/res/jsp/admin/changepass.jsp?no=2");
			rd.forward(req, resp);
		}
		
		
		
		
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
