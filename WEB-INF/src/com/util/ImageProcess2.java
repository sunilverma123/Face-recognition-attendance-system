package com.util;

import java.io.DataInputStream;
import java.net.*;



import com.dao.AdminDAO;
import com.opencv.algorithm.RANSCAR;

public class ImageProcess2 
{
	ImageProcess2()
	{
		
		System.out.println("=================Homography=====================");
		Thread t=new Thread(new PortListener(8660));
		t.start();
		
	}
	
	class PortListener implements Runnable
	{
		
		int port;
   		public PortListener(int port ) 
   		{
   			this.port=port;
   			run();

   		}
		
		public void run() 
		{
			
			try
			{
				RANSCAR ranscar=new RANSCAR();
				
				
				ServerSocket ServerSocket=new ServerSocket(port);
				while(true)
				{
					
					Socket sock=ServerSocket.accept();
					System.out.println(" accept :"+sock);
					DataInputStream dis=new DataInputStream(sock.getInputStream());
					int fid=dis.readInt();
					String fname=dis.readUTF();
					String fname2=dis.readUTF();
					String fwritepath=dis.readUTF();
					
					System.out.println(fname);


					int distance3=ranscar.homography(fname, fname2,fwritepath);
				    boolean flag = AdminDAO.updateImgDist4Feature3(fid,distance3);
					
					
				}
				
			}
			catch(Exception df)
			{
				df.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new ImageProcess2();
	}
}
