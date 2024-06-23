package com.dao;

import java.sql.SQLException;

import servicelocator.ServerConnector;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class AdminDAO 
{
public static boolean LoginCHCK(String uname,String upass)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+uname+"' and apass='"+upass+"' ";
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




public boolean addAdmin(String [] values)
{
	boolean flag=false;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		
		System.out.println("insert into m_admin (aname,apass,addr,pno,email,name,m_image) values('"+values[0]+"','"+values[1]+"','"+values[3]+"','"+values[4]+"','"+values[5]+"','"+values[2]+"','"+values[6]+"')");
		int i = st.executeUpdate("insert into m_admin (aname,apass,addr,pno,email,name,m_image) values('"+values[0]+"','"+values[1]+"','"+values[3]+"','"+values[4]+"','"+values[5]+"','"+values[2]+"','"+values[6]+"')");
		if(i==1)
		{
			flag=true;
		}
		System.out.println("Admin Registration Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in addAdmin(String [] values): "+ e);
	}
	return flag;
}




public static boolean loginCheck(String [] values)
{
	boolean flag=false;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+values[0]+"' and apass='"+values[1]+"' ";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
	
		while(rs.next())
		{
			flag=true;
		}
		System.out.println("Admin Login Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->loginCheck(String user,String pass): "+ e);
	}
	return flag;
}

public static boolean LoginCHCK2(String aname,String apass)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+aname+"' and apass='"+apass+"' ";
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





public static String getImage(String [] values)
{
	String image_Name="";
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try
	{
		
		Statement st=(Statement) con.createStatement();
		String sql="select m_image from m_admin where aname='"+values[0]+"'";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
		
		while(rs.next())
		{
			image_Name=rs.getString(1);
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getImage(String id): "+ e);
	}
	return image_Name;
}



public String getAdminId(String adminName)
{
	String adminId="";
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try
	{
		
		Statement st=(Statement) con.createStatement();
		String sql="select aname from m_admin where name='"+adminName+"'";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
		
		while(rs.next())
		{
			adminId=rs.getString(1);
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getImage(String id): "+ e);
	}
	return adminId;
}


public static boolean Changepass(String aname,String x_new_pass)
{
	
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set apass='"+x_new_pass+"' where aname='"+aname+"'";
		System.out.println("Sql....."+sql);
		int i=st.executeUpdate(sql);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return true;
}

public static boolean updateAttendance(String uname)
{
	String count=null;
	
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		
		String sql="select attendance from m_user where uname='"+uname+"'";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
		
		while(rs.next())
		{
			count=rs.getString(1);
		}
		
		int count2 = Integer.parseInt(count);
		count2++;
		
		String count3 = count2+"";
		
		
		
		String sql2="update m_user set attendance='"+count3+"' where uname='"+uname+"'";
		System.out.println("Sql....."+sql);
		int i=st.executeUpdate(sql2);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return true;
}



public static ResultSet profile(String uid)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		System.out.println("admin id in DAO is:"+uid);
		String sql="select * from m_admin where aname='"+uid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}



public static ResultSet getMatchPercentage(int id)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		System.out.println("admin id in DAO is:"+id);
		String sql="select * from m_match where id='"+id+"'";
		rs=(ResultSet) st.executeQuery(sql);
		System.out.println("get match percentage is done");
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}




public static ResultSet getClassifications() 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getClassifications() : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getUserName() 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_user");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getClassifications() : ");
		e.printStackTrace();
	}
	return rs;
}


public static boolean checkClassificationExistance(String classificationName)
{
	boolean flag=false;
	String sql = "";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_classification where c_name='"+classificationName+"'";
		System.out.println("********** Check Classification Existance Info **********");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	
		while(rs.next())
		{
			flag=true;
		}
		System.out.println("Classification Existance Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>checkgetClassificationExistance(String classificationName) : ");
		e.printStackTrace();
	}
	return flag;
}


public static boolean addClassificationDetails(String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_classification(c_name,c_remark) values('"+classificationName+"','"+remarks+"')";
		System.out.println("********** Add Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addClassificationDetails(String classificationName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;
}


public static ResultSet getClassification(int classificationId) 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return rs;
}

public static String getClassificationName(String classificationId) 
{
	ResultSet rs=null;
	String cname=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	while(rs.next())
	{
		cname=rs.getString(2);
	}
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return cname;
}



public static boolean updatClassificationDetails(int classificationId,String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_classification set c_name='"+classificationName+"',c_remark='"+remarks+"' where c_id='"+classificationId+"'";
		System.out.println("********** Update Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Update Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updatClassificationDetails(): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean deleteClassificationDetails(int classificationId)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{

		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_classification where c_id='"+classificationId+"'";
		System.out.println("********** Delete Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Delete Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>deleteClassificationDetails(int classificationId): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateprofile(String uid,String uname,String umail,String uphone,String addr)
{
	String name1="";
	ResultSet rs=null;
	boolean flag=false;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set name='"+uname+"',email='"+umail+"',pno='"+uphone+"',addr='"+addr+"' where aname='"+uid+"'";
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

public static boolean imgUpdate(String fname)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="insert into Tcount (fname) value('"+fname+"') ";
		int k=st.executeUpdate(sql);
		System.out.println("K :"+k);
		if(k>0)
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return flag;
	
}


public static ResultSet getImgcount()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from Tcount";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImgcat()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_imgclasification";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}




public static int getImageCount1LastUpdate()
{
	String sql="";
    int name=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select img_id from m_image order by img_id DESC limit 1";
		System.out.println("********** Get Image count Info **********");
		System.out.println(sql);
		ResultSet rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			name = rs.getInt(1);
		}
		System.out.println("image count is ++++"+name);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
		e.printStackTrace();
	}
	return name;
}




public static boolean addImageDetailsUnTrained(String imageFileName,String cid,String name,String address)
{
	boolean flag = false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_image(img_name,cid,name,address) values('"+imageFileName+"','"+cid+"','"+name+"','"+address+"')";
		System.out.println("********** Add Image Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Image Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addImageDetails(String imageFileName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;

	
	
}




public static boolean addPrintedImage(String imageFileName,String cid)
{
	boolean flag = false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_printed_image(img_name,cid) values('"+imageFileName+"','"+cid+"')";
		System.out.println("********** Add Image Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Image Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addImageDetails(String imageFileName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;
}







public static ResultSet getUsers()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_feedback";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getUsers2()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_user";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}


public static ResultSet getImage()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImage1(String cid)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image where cid='"+cid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}


public static ResultSet getImage2(String cid)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_printed_image where cid='"+cid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}










public static boolean updateImgFeature2(int imageId,double imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,double imgFeature2) : ");
		e.printStackTrace();
	}
	return flag;
}





//Resetting (ENDS)

public static boolean updateImgFeature1(int imageId,String imgFeature1)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature1='"+imgFeature1+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature1 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature1 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature1(int imageId,String imgFeature1): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgFeature2(int imageId,String imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,String imgFeature2): ");
		e.printStackTrace();
	}
	return flag;
}






public static ResultSet getTopNimg4Feature1Comparision(int noOfRecords) 
{
	String sql="";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature1 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getImageTopNimg(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature2Comparision(int noOfRecords) 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image where f_dist !='"+defaultValue+"' order by f_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature2 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature2Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature3Comparision(String noOfRecords) 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image where cid='"+noOfRecords+"' order by f_dist desc ";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature3Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}








public static int getPersonName() 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	String cid=null;
	int distance = 0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select f_dist,MAX(f_dist) from m_image group by f_dist desc limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			distance=rs.getInt(1);
		}
		System.out.println("+++++++++++cid++++++++++ "+cid);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return distance;
}











public static String getClasificationId() 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	String cid=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f_dist desc limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			cid=rs.getString(4);
		}
		System.out.println("+++++++++++cid++++++++++ "+cid);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return cid;
}

public static String getClasificationId2() 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	String cname=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f_dist desc limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			cname=rs.getString(5);
		}
		System.out.println("+++++++++++cid++++++++++ "+cname);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return cname;
}

public static String getClasificationId3() 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	String caddress=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f_dist desc limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			caddress=rs.getString(6);
		}
		System.out.println("+++++++++++cid++++++++++ "+caddress);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return caddress;
}




/*public static boolean updateImgDistance(int imageId,double distance)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f1_dist='"+distance+"' where img_id='"+imageId+"'";
		
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
}*/

public static boolean updateF2Distance()
{
	boolean flag=false;
	String sql= "";
	double defaultValue = -1;
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f_dist='"+defaultValue+"'";
		System.out.println("********** Update F2 Distance(f_dist) Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update F2_Dist Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateF2Distance() : ");
		e.printStackTrace();
	}
	return flag;
}



public static boolean updateImgDist4Feature2(int imageId,double distance2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f_dist='"+distance2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature2(int imageId,double distance2) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgDist4Feature3(int imageId,int distance3)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f_dist='"+distance3+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}


public static boolean updateMatchingDist(int imageId,int distance3)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_match set dist='"+distance3+"' where id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}


public static boolean updateMatchPercentage(int imageId,double distance3)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_match set match_percen='"+distance3+"' where id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}







}
