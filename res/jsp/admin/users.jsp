
<%@page import="com.dao.AdminDAO"%>
<%@ page import="java.sql.*" %>
<html>

<head>
    <title>User List</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/contact1.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/buttons.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
</head>

<%!
	ResultSet rs = null;
%>

<%
	rs = AdminDAO.getUsers2();
int k=1;
%>

<body onload="startTimer()">
<br><br>
<form action="<%=request.getContextPath() %>/UserList">

<table cellspacing="15" id="results" class="tab" align="center" style="">
	<tr align="center">
	    <th>Sno</th>
		<th>User ID</th>
		<th>Name</th>
		<th>Password</th>
		<th>Address</th>
		<th>PhoneNO</th>
		<th>EmailID</th>
	</tr>
<%
		while(rs.next())
		{
%>
			<tr align="center">
				<td><%=k%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
				<td><%=rs.getString(7)%></td>
			</tr>
<%
k=k+1;
		}
%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 3); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

</body>
</html>