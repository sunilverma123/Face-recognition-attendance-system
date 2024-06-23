package com.user.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.AdminDAO;

public class ImageMatching extends HttpServlet
{

public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{
	
	RequestDispatcher rd = null;
	HttpSession session = request.getSession();
	response.setContentType("text/html");

	FileItemFactory fileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
	try {

		List fileItems = servletFileUpload.parseRequest(request);
		
		
		FileItem file = (FileItem) fileItems.get(0);
		
		
		// Read First Files //
		
		int m =1;

		String fnm = m + "_" + file.getName();
		System.out.println("new File name :"+fnm);
		
		
		
		String fileName = request.getRealPath("") + "/Temp2/"+m+"_"+ file.getName();
		

		
		OutputStream outputStream = new FileOutputStream(fileName);
		InputStream inputStream = file.getInputStream();

		int readBytes = 0;
		byte[] buffer = new byte[10000];
		while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
		{
			outputStream.write(buffer, 0, readBytes);
		}
		outputStream.close();
		inputStream.close();
		 session.setAttribute("firstimg_name",m+"_"+ file.getName());
		 
		 
		 
		 
		 request.setAttribute("image_name",m+"_"+ file.getName());
         rd=request.getRequestDispatcher("/res/jsp/user/imageMatch.jsp?no=11");
		 rd.forward(request, response);
		 
}catch (Exception e) {
	e.printStackTrace();
}
}
}

