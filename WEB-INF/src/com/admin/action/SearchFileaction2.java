/**
 * @author
 */
package com.admin.action;


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


public class SearchFileaction2 extends HttpServlet {
	

	static float count=(float) 0.0;
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		
		String f = "";
		String dest ="", dest1="";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		HttpSession hs = request.getSession();

		//String id = hs.getAttribute("useid1").toString();

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try {

			List fileItems = servletFileUpload.parseRequest(request);
			
			
			FileItem file = (FileItem) fileItems.get(0);

			// Read First Files //
			
			int m = AdminDAO.getImageCount1LastUpdate();
			m = m++;

			String fnm = m + "_" + file.getName();
			System.out.println("new File name :"+fnm);
			
			
			
			String fileName = request.getRealPath("") + "/File/search/"+m+"_"+ file.getName();
			

			
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
			 session.setAttribute("img_name",m+"_"+ file.getName());
			 
			 
			 
			 
			 request.setAttribute("image_name",m+"_"+ file.getName());
           	rd=request.getRequestDispatcher("/res/jsp/admin/upload2.jsp?no=11");
				rd.forward(request, response);
			 
			/*if (file.getName() != null)
			{
			
				boolean flag2 = AdminDAO.addImageDetailsUnTrained(fnm);
				
				if (flag2) {

					
					rd = request
							.getRequestDispatcher("/res/jsp/admin/upload1.jsp?no=1");
					rd.forward(request, response);
				} else {
					System.out
							.println("Opps,Something Went Wrong While Uploading The Image!!!!");
					rd = request
							.getRequestDispatcher("/res/JSP/Admin/upload1.jsp?no=2");
					rd.forward(request, response);
				}
				
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/res/JSP/Admin/upload1.jsp?no=2");
				dispatcher.forward(request, response);
			}
			*/
			
			
			
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
