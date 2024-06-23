package com.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;

public class AddImage extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	HttpSession session=req.getSession();
	String fname= session.getAttribute("img_name").toString();
	
	String category=req.getParameter("classification");
	String name=req.getParameter("cname");
	String address=req.getParameter("address");
	
	RequestDispatcher rd;
	boolean flag2 = AdminDAO.addImageDetailsUnTrained(fname,category,name,address);
	
	if (flag2) {

		
		rd = req
				.getRequestDispatcher("/res/jsp/admin/upload2.jsp?no=1");
		rd.forward(req, resp);
	} else {
		System.out
				.println("Opps,Something Went Wrong While Uploading The Image!!!!");
		rd = req
				.getRequestDispatcher("/res/JSP/Admin/upload2.jsp?no=2");
		rd.forward(req, resp);
	}
	
}
}
