package com.admin.action;

import java.io.File;
import java.io.IOException;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.AdminDAO;
import com.dao.UserDAO;

public class AdminLogin extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	try
	{
		
		
		String aname=req.getParameter("username");
		String apass=req.getParameter("password");
		System.out.println("got Value :"+aname+" "+apass);
		HttpSession session=req.getSession();
		
		
		boolean flag=AdminDAO.LoginCHCK2(aname, apass);
		
		
		
		if(flag)
		{
			session.setAttribute("aid", aname);
			RequestDispatcher rd=req.getRequestDispatcher("/res/jsp/admin/home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp?no=1");
			rd.forward(req, resp);
		}
		
		
		
		
		/*String adminName = "";
		String uname=req.getParameter("username");
		String upass=req.getParameter("password");
		System.out.println("got Value :"+uname+" "+upass);
		
		
		HttpSession session=req.getSession();
		
		
		
		
		RequestDispatcher rd=null;
		//code to browse file
		String fileName="";
		String [] values=new String[3];
		int i=0;
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) 
        {
			boolean result=false;
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try 
            {
                List items = upload.parseRequest(req);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) 
                {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) 
                    {
                    	fileName = item.getName();
                        System.out.println("======>"+fileName);
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/File/L_Images");
                        System.out.println("Path--->"+path);
                        if (!path.exists()) 
                        {
                        	boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    }
                    else
                    {
                    	String value=item.getString();
                    	values[i]=value;
                    	i++;
                    }
                }values[i]=fileName;
             }
            catch (FileUploadException e) 
            {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
           UserDAO userDAO=UserDAO.initialize();
           boolean check = userDAO.loginCheck(values);
            boolean flag=AdminDAO.loginCheck(values);
            adminName = values[0];
            System.out.println("admin name is+++++++++++++++++++++++++++++++++++++++"+adminName);
           if(flag)
           {
        	  
        		   session.setAttribute("adminName", adminName);
        		   System.out.println("admin name is+++++++++++++++++++++++++++++++++++++++"+adminName);
        		   rd=req.getRequestDispatcher("/res/jsp/admin/home.jsp");
        			rd.forward(req, resp);
        	   }
        	   
         
           else
           {
        	   resp.sendRedirect(req.getContextPath()+"/index.jsp?no=1");
           }
        }*/
	}
	catch(Exception e)
	{
		System.out.println("Error in Login Servlet................."+e);
		
	}
	
}
}
