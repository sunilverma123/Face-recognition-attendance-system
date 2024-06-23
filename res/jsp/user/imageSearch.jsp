<%@page import="com.dao.AdminDAO"%>
<%@page import="com.util.Utility"%>
<html>
<head>
    
    <title>Face Recognition Attendance System</title>
    
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js" type="text/javascript"></script>

</head>
<body onload="startTimer()">
<div class="container" id="label" style="position:absolute;top:7px;left:150px;width:550px;height:440px;">

<%!
	int no = 0,no1=0;
	String fileName = "";
%>

<%	
	no = Utility.parse(request.getParameter("no"));
	no1 = Utility.parse(request.getParameter("no1"));
	if(no==1)
	{
%>
		<div class="success" id="message">	
			<p>Face Image Searching Process Done Successfully.....</p>
		</div>				
<%
	}
	if(no==2)
	{
%>
			<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
			</div>			
<%
	}
	if(no==3)
	{
%>
			<div class="error" id="message">	
				<p>Opps,Something Went Wrong While image1 Comparison!!!!!</p>
			</div>			
<%
	}
	if(no==4)
	{
%>
			<div class="error" id="message">	
				<p>Opps,Something Went Wrong While image2 Comparison!!!!!</p>
			</div>			
<%
	}
	if(no==0 & no1==1)
	{
%>
		<div class="success" id="message">	
			<p>Requested Process Done Successfully.....</p>
		</div>				
<%
	}
	if(no==0 & no1==2)
	{
%>
		<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
		</div>	
<%
	}
%>
   
<div class="TabMenu" style="position: relative;left:0px;text-align: center;">
	<span>
		<img src="<%=request.getContextPath() %>/res/images/search.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	<h2 style="color: #000000">Search Image to Mark Attendance<h2>
</div>	

<hr size="10" color="#351616"></hr>

<%
	if( no == 0)
	{
%>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/SearchFileAction" enctype="multipart/form-data" method="post">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<!-- <p><h2 style="color: #000000">Search Iris Image Files</h2> -->
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td style="color: #000000">
		  						Browse Image File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr height="35px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Search Image"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>

		
<%
	}// Ends  if(no == 0)
	else if(no == 11)
	{
		fileName = (String)request.getAttribute("image_name");
		System.out.println("===user side===="+fileName);
		
%>

	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		  <table align="center" id="login">
		    <form action="<%=request.getContextPath()%>/SearchImage" method="post">
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<img src="<%=request.getContextPath() %>/File/uploadedImg/<%=fileName %>" height="200" width="200" />
		 			</td>
		 	</tr>
		 	
		 	<tr height="10px"></tr>
		 	
		 	<tr align="center">
		 		 <td align="center">
		 		 		<input  class="button" type="submit" value="Search Image"/>
		 		 </td>
		 	</tr>
		 	
		 	</form>
		 	</table>
		</div>
		
	</div>
</div>

<%		
		
	}
	else if(no == 22)
	{
		
		
		 String cid = AdminDAO.getClasificationId();
		 String cri_name = AdminDAO.getClasificationId2();
		 String c_address = AdminDAO.getClasificationId3(); 
		 
		 AdminDAO.updateAttendance(cri_name); // updating attendance
		 
		    
		    String cName=AdminDAO.getClassificationName(cid);
%>
	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		  <table align="center" id="login">
		    <form action="<%=request.getContextPath()%>/res/jsp/user/view_file.jsp" method="post">
		 	<input type="hidden" name="cid" value="<%=cid%>">
		 	<tr align="center">
		 			<td align="center" colspan="3">
		 					<font color="#003366" size="6">Image Retrieval Information </font>
		 			</td>
		 	</tr>
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<font color="#FF00FF" size="4">Result</font>
							
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=cName%></font>
		 			</td>
		 	</tr>
		 	
		 	 <tr align="center">
		 			<td align="center">
		 					<font color="#FF00FF" size="4">Name</font>
							
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=cri_name%></font>
		 			</td>
		 	</tr>
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<font color="#FF00FF" size="4">Address</font>
							
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=c_address%></font>
		 			</td>
		 	</tr>
		 	
		 	 
		 			
		 	
		 	<tr height="10px"></tr>
		 	
		 	<tr align="center">
		 		 <td align="center" colspan="3">
		 		 		<input  class="button" type="submit" value="View Image"/>
		 		 </td>
		 	</tr>
		 	
		 	</form>
		 	</table>
		</div>
		
	</div>
</div>

<%		
		
	}
	if(no==22)
	{
%>
		<div class="success" id="message" style="position: absolute;top: 40px;left:100px;">	
			<p>Face Image Searching Process Done Successfully.....</p>
		</div>				
<%
	}
%>


</div>	

</body>
</html>