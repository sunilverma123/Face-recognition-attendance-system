
package com.user.action;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.AdminDAO;


@SuppressWarnings("serial")
public class SearchImage extends HttpServlet 
{
	static Thread t;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		//PrintWriter out1 = response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		int imageId = 0;
		
		String fileName="",root = "",filePath = "",filePath2 = "";
		
		
		
		
		long start=0,end=0;
		
		try
		{
			
			
			//RANSCAR ranscar=new RANSCAR();
		   root = request.getRealPath("")+"\\File\\uploadedImg\\";
		   //long startTime = System.currentTimeMillis();
		   start = System.nanoTime();
		 
		   if( session.getAttribute( "waitPage" ) == null ) 
		   {  
			   PrintWriter out = response.getWriter();
		 
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );
	    	   out.println("<section id='content' style='position: absolute;top:25;left:100px;width: 650px;'>");
	    	   out.println("<center>");
	    	   //out.println("<br>");
	    	   out.println("<font color='blue' size='5'>");
	    	   out.println( "Wait Please...<br>" );
	    	   out.println( "Image Search Process is in Progress.....<br><br>" );
	    	   out.print( "<img src='res/images/spinner.gif'></img><br><br>");
	    	   out.println("<font color='red' size='5'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font><br>");
	    	   out.println("<font color='green' size='5'>");
	    	   out.println( "Images Are Getting Searched..... " );
	    	   out.println("</font><br>");
	    	   out.println( "Please wait....</h1><br>");  
	    	   out.println("</center>");
	    	   out.println("</section>");
	    	   out.close();  
		     }
			 else
			 {
				session.removeAttribute( "waitPage" );
				
				try
				{
					
					 fileName = (String) session.getAttribute("img_name");
					 filePath = root+fileName;
					 System.out.println("Selected Image File Path : " + filePath);
					 
					
					//Getting Distance With All DB Files
					 root = request.getRealPath("")+"\\File\\search\\";
					 
					
					 
					 rs = AdminDAO.getImage();
					 while(rs.next())
					 {
						
						
						imageId = rs.getInt(1);
						fileName = rs.getString(2);
						filePath2 = root+fileName;
						System.out.println("Image File Path : " + filePath2);
						
						    
						    //distance = histogram.compare(filePath, filePath2);
						    
						    String fwritepath=request.getRealPath("")+"//matchedImages//"+fileName;
						  /*  SendImageFname(filePath,filePath2,imageId);*/
						    SendImageFname2(filePath,filePath2,imageId,fwritepath);
						    
						   
						    
				/*		flag=true;    */
						    
					 }
					 
					
					 	Thread.sleep(5000);
						
						int dist = AdminDAO.getPersonName();
						System.out.println("distace value is++++++++++++++"+dist);
						
						if(dist>10)
						{
							 	Thread.sleep(5000);
								
								rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=22");
								rd.forward(request, response);
							
						}
						else
						{
							Thread.sleep(5000);
							
							rd=request.getRequestDispatcher("/res/jsp/user/imageSearch2.jsp?no=22&no1=5");
							rd.forward(request, response);
							
						}
						 
					/* if(flag)
					 {
						
						 Thread.sleep(5000);
						
						rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=22");
						rd.forward(request, response);
						
					 }*/
					/* else
					 {
						rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
						rd.forward(request, response);
					 }*/
					
					
/*					
*/				
					 
				}
				catch (Exception e)
				{
					System.out.println("Opps,Exception In SearchImage Servlet Main Block : " );
					e.printStackTrace();
					rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
					rd.forward(request, response);
				}
		   
			 }
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in SearchImage Servlet : ");
			e.printStackTrace();
			//out.println("Opps's Error is in SearchImage Servlet : "+e);
			rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
			try
			{
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
		}
		
		
		
		
	}
	/*public static void SendImageFname(String filepath,String filepath2,int imgid)
	{
		Socket client;
		SearchImage x=new SearchImage();
		try 
		{
			System.out.println("======histogram======>  send");
			client = new Socket("localhost", 17000);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
			
			dos.writeInt(imgid);
			dos.writeUTF(filepath);
			dos.writeUTF(filepath2);
			dos.writeBoolean(true);
			dos.flush();
			dos.close();
			client.close();
			
			
			
			System.out.println("======================================");
			
			
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
	*/
	
	
	public static void SendImageFname2(String filepath,String filepath2,int imgid,String fwritepath)
	{
		Socket client;
		try 
		{
			System.out.println("=====homography=======>  send");
			client = new Socket("localhost", 8660);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
			dos.writeInt(imgid);
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
