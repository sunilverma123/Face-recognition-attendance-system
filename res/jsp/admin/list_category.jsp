<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Face Recognition Attendance System</title>

<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container" id="label" style="position:absolute;top:7px;left:150px;width:550px;height:440px;">
<center>
<h1>Select Face Category</h1></center>
<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/res/jsp/admin/view_file.jsp" >
		  		<tr>
		  				<td><label>Category</label>
		  						<select name="classification" style="width: 190px;border:5px solid #351616;font-size:12px;line-height:1.5em;padding:4px; ">
		  						
		  						<%
		  							ResultSet rs = AdminDAO.getClassifications();
		  							while(rs.next())
		  							{
		  						%>
		  								<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
		  						<%
		  							}
		  						%>
		  									
		  						</select>
		  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="View Images"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>
</div>
</body>
</html>