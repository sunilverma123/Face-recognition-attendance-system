<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Face Recognition Attendance System</title>

<script type="text/javascript">

function checkboxval()
{
	
	var id=document.getElementsByName("loc_code");
	
	var no=0;
	
	for(var i=0;i<id.length;i++)
	{
		if(id[i].checked)
			{
				no++;
			}
	}
	if(no==0)
	{
		alert("You must Select atleast one checkbox");
		return false;
	}
	else
	
		return true;
}
</script>

<%
ResultSet rs1=AdminDAO.getImgcat();

%>


<link href="<%=request.getContextPath() %>/res/CSS/container.css" rel="stylesheet" type="text/css" /> 

</head>
<body>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 
		  <form action="<%=request.getContextPath()%>/AddImage" method="post"> 
		 	
		 			<center>
		 			
		 			<label>Select Category :</label>
		 			
		 			<select name="drop">
		 			<%while(rs1.next())
		 				{
		 				%>
		 			 <option value="<%=rs1.getString(1) %>"><%=rs1.getString(2) %></option>
		 			 
		 			  <%
		 				}
		 			  %>
		 			</select>
		 			</center>
		 			
		 			<%
		 			
		 			ResultSet rs=AdminDAO.getImgcount();
		 			
		 			
		 			
		 			String k="";
		 			while(rs.next())
		 			{
		 				
		 			
		 			
		 			%>
		 			        
		 			        <div class="container">
                               <img  src="<%=request.getContextPath()%>\Temp2\<%=rs.getString(2)%>" /> 
                          <input type="checkbox" class="checkbox" name="loc_code" value="<%=rs.getString(2)%>"/>
                            </div>
		 			
		 					
		 					
		 					
		 			
		 			<%
		 			
		 			
		 			}
		 			%>
		 	
		 	
		 
		 	<center>
		 	
		 	<input type="submit" name="submit" id="add" value="ADD" onclick="return checkboxval()"></input></center>
		 	</form>
		 	
		</div>
		
	</div>
</div>

</body>
</html>