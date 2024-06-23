/**
 * 
 */
package com.admin.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.AdminDAO;


public class RegisterAdmin extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			RequestDispatcher rd=null;
			String fileName="";
			AdminDAO adminDAO=new AdminDAO();
			String [] values=new String[7];
			int i=0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) 
	        {
				FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            try
	            {
	            	List items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) 
	                {
	                	FileItem item = (FileItem) iterator.next();
	                	if (!item.isFormField()) 
	                    {
	                		fileName = item.getName();
	                        System.out.println("======>"+fileName);
	                        String root = getServletContext().getRealPath("/");
	                        File path = new File(root + "/File/A_Images");
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
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            boolean result=adminDAO.addAdmin(values);
	            if(result)
	            {
	            	rd=request.getRequestDispatcher("/res/jsp/admin/register.jsp?no=1");
					rd.forward(request,response);
	            }
	            else
	            {
	            	response.sendRedirect(request.getContextPath()+"/res/jsp/admin/register.jsp?no=2");
	            }
	        }
		}
		catch(Exception e)
		{
			System.out.println("Error in RegisterAdmin Servlet................."+e);
			out.println("Error in RegisterAdmin Servlet................."+e);
		}
	}
}
