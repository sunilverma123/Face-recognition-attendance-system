
<%@page import="com.dao.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Face Recognition Attendance System</title>

<link href="<%=request.getContextPath() %>/js/message.css" rel="stylesheet" type="text/css" /> 

<script type="text/javascript" src="<%=request.getContextPath() %>/js/style.js"></script>	

<%
int no=Integer.parseInt(request.getParameter("no"));
String uid=session.getAttribute("uid").toString();
ResultSet rs=UserDAO.userProfile(uid);

%>

</head>
<body onload="startTimer();">
<form action="<%=request.getContextPath()%>/res/jsp/user/editProfile.jsp" >
<center>
<h1>PROFILE</h1>
<%
while(rs.next())
{
	%>
<table border="1">
<tr><td><label>Name :</label></td>
<td><input type="text" name="uid" value="<%=rs.getString(4)%>"readonly="readonly"></td></tr>
<tr><td><label>Admin ID :</label></td>
<td><input type="text" name="uid" value="<%=uid%>"readonly="readonly"></td></tr>

<tr><td><label>Password :</label></td>
<td><input type="text" name="uid" value="<%=rs.getString(3)%>"readonly="readonly"></td></tr>

<tr><td><label>Address :</label></td>
<td><input type="text" name="uid" value="<%=rs.getString(5)%>"readonly="readonly"></td></tr>



<tr><td><label>Phone NO :</label></td>
<td><input type="text" name="uid" value="<%=rs.getString(6)%>"readonly="readonly"></td></tr>

<tr><td><label>Email ID :</label></td>
<td><input type="text" name="uid" value="<%=rs.getString(7)%>"readonly="readonly"></td></tr>
</table>
<% 
}
%><br>
<input type="hidden"name="no"value="5">
<input type="submit" value="Edit Profile" style="color: green">
</center>
</form>
<%
if(no==2)
	{%>
		<div style="position:absolute;top:170px;left:210" class="c">	
		<%
			
			%>
				<div class="success" id="message" >	
					<p>Profile Updated Successfully .....!</p>
				</div>			
			<%
		%>
        <%
	}%>
</body>
</html>