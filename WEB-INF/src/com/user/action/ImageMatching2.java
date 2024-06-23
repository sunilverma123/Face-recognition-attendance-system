package com.user.action;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.opencv.algorithm.RANSCAR;

public class ImageMatching2 extends HttpServlet
{

public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{
	ResultSet rs5=null;
	
	RequestDispatcher rd = null;
	HttpSession session = request.getSession();
	response.setContentType("text/html");
	
	FileItemFactory fileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
	try {

		List fileItems = servletFileUpload.parseRequest(request);
		
		
		FileItem file = (FileItem) fileItems.get(0);
		
		
		// Read First Files //
		
		int m =2;

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
		 session.setAttribute("secondimg_name",m+"_"+ file.getName());
		 String img1=session.getAttribute("firstimg_name").toString();
		 
		 
		String root = request.getRealPath("")+"\\Temp2\\";
		 String filePath=root+img1;
		String filePath2=root+m+"_"+ file.getName();
		
		String fwritepath=root+"matching.jpg";
		
		 SendImageFname2(filePath,filePath2,fwritepath);
		 Thread.sleep(5000);
		 
		 
		 String dist5 = "";
		 String percentage = "";
		 
		 try
		 {
		 int id5 = 1;
		 rs5 =(ResultSet) AdminDAO.getMatchPercentage(id5);
		 
		 while (rs5.next()) 
		 {
			 dist5 = rs5.getString(2);
			 percentage = rs5.getString(3);
			    
			}
		 
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		
		 System.out.println("getting dist5 "+dist5);
		 System.out.println("getting percentage "+percentage);
		 request.setAttribute("dist", dist5);
		 request.setAttribute("percen", percentage);
       	rd=request.getRequestDispatcher("/res/jsp/user/imageMatch.jsp?no=22");
		rd.forward(request, response);
		 
}catch (Exception e) {
	e.printStackTrace();
}
}


public static void SendImageFname2(String filepath,String filepath2,String fwritepath)
{
	Socket client;
	try 
	{
		System.out.println("=======matches=====>  send");
		client = new Socket("localhost", 9661);
		DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
		
		dos.writeUTF(filepath);
		dos.writeUTF(filepath2);
		dos.writeUTF(fwritepath);
		dos.writeBoolean(true);
		dos.flush();
		dos.close();
		client.close();
	} 
	catch (UnknownHostException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	
}
}