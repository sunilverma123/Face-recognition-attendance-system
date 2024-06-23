package com.dao;

import java.sql.SQLException;

import servicelocator.ServerConnector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class UserDAO
{

	public static boolean userRegister(String uname,String upass,String uid,String addr,String email,String pno)
	{
		String attendance="0";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_user (u_id,u_pass,uname,addr,pno,email,attendance) values ('"+uid+"','"+upass+"','"+uname+"','"+addr+"','"+pno+"','"+email+"','"+attendance+"')";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
	
	
	
	public static boolean userFir(String name,String addr,String pno,String fir_report)
	{
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_feedback (uname,addr,pno,feedback) values ('"+name+"','"+addr+"','"+pno+"','"+fir_report+"')";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
	
	
	
	
	
	public static boolean LoginCHCK(String uname,String upass)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uname+"' and u_pass='"+upass+"' ";
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
	
	
	
	public static boolean userCategoryCheck(String uname)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_classification where c_name='"+uname+"'";
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
	
	
	
	public static boolean uidCHCK(String uname,String upass)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uname+"' and u_pass='"+upass+"' ";
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	public static String getuid2(String uid) throws SQLException
	{
		System.out.println("vhvhv vhvbbv"+uid);
		String uname=null;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		//try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uid+"' ";
			System.out.println("sql :"+sql);
			
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				uname=rs.getString(4);
			}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		
		return uname;
		
	}
	
	public static ResultSet userProfile(String uid)
	{
		ResultSet rs=null;
		try{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uid+"'";
			rs=(ResultSet) st.executeQuery(sql);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static boolean userChangepass(String aname,String x_new_pass)
	{
		
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_user set u_pass='"+x_new_pass+"' where u_id='"+aname+"'";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static boolean userUpdateprofile(String uid,String uname,String umail,String uphone,String addr)
	{
		String name1="";
		ResultSet rs=null;
		boolean flag=false;
		try{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_user set uname='"+uname+"',email='"+umail+"',pno='"+uphone+"',addr='"+addr+"' where u_id='"+uid+"'";
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet getImageByDistAsc() 
	{
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image order by f1_dist asc ");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	

	public static ResultSet getFirstNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql first search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where remarks='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getsecondNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql second search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where secondName='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getthirdNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql second search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	public static boolean updateFirstImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			//System.out.println("came to sql third search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set remarks='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateSecondImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set secondName='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateThirdImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set thirdName='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet getallNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql...");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_image where remarks='"+imgName+"' or secondName='"+imgName+"' or thirdName='"+imgName+"'";
			System.out.println("sql :"+sql);
			rs = (ResultSet) st.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
}
