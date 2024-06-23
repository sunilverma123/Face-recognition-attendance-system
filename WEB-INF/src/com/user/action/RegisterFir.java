package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

public class RegisterFir extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{
	
	String username=req.getParameter("username");
	String addr=req.getParameter("addr");
	String pno=req.getParameter("pno");
	String fir_report=req.getParameter("fir_report");
	/*if(upass.equals(rpassword))
	{
		
		boolean flag1=UserDAO.uidCHCK(username, upass);
		if(flag1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index1.jsp?no=3");
			rd.forward(req, resp);
			
		}else
		{*/
			
			
			
			boolean flag=UserDAO.userFir(username, addr, pno,fir_report);
			if(flag)
			{
				RequestDispatcher rd=req.getRequestDispatcher("/res/jsp/user/feedback.jsp?no=2");
				rd.forward(req, resp);
			}else
			{
				RequestDispatcher rd=req.getRequestDispatcher("/res/jsp/user/feedback.jsp?no=2");
				rd.forward(req, resp);
				
			}	
	/*	}*/
		
		
		
	/*}else
	{
		RequestDispatcher rd=req.getRequestDispatcher("/signup.jsp?no=1");
		rd.forward(req, resp);
		
	}*/
	
}
}
