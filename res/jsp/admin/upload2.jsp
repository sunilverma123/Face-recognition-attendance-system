
<%@page import="com.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.awt.Toolkit"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.swing.ImageIcon"%>
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
				<p>Opps,Something Went Wrong While Comparison!!!!!</p>
			</div>			
<%
	}
	if(no==4)
	{
%>
			<div class="error" id="message">	
				<p>Opps,Something Went Wrong While Comparison!!!!!</p>
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
	
<%
		if(no == 22)
		{
%>
	<h2>Face Identification System<h2>
<%
		}
		else
		{
%>	
	
<%
	} 
%>	
</div>	



<%
	if( no == 0)
	{
%>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/SearchFileaction2" enctype="multipart/form-data" method="post">
		  		<h2 style="color: #CC00FF">Upload Image <h2>
		  		<hr size="10" color="#351616"></hr>
		  		
		  		
		  		<tr>
		  				<td id="label" style="color: #0000CC">
		  						Browse Image File : 
		  				</td>
		  				
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		
		  		
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Upload Image"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>
<%
if(no==1)
	{
%>
		<div class="success" id="message">	
			<p>Face Image Added Successfully.....</p>
		</div>
		
						
<%
	}
%>
		
<%
	}// Ends  if(no == 0)
	else if(no == 11)
	{
		fileName = (String)request.getAttribute("image_name");
		
		System.out.println("image fileName+++++++"+fileName);
%>

	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		  <table align="center" id="login">
		    <form action="<%=request.getContextPath()%>/AddImage" method="post">
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<img src="<%=request.getContextPath() %>/File/search/<%=fileName %>" height="150" width="150" />
		 			</td>
		 	</tr>
		 	
		 	<tr height="10px"></tr>
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
		  				<td align="center">
		  				</td>
		  				</tr>
		  				
		  				<tr>
		  				<td align="center">
		  				Name   :<input type="text" name="cname" required="yes"></input>
		  				</td>
		  				</tr>
		  				
		  				<tr>
		  				<td align="center">
		  				</td>
		  				</tr>
		  				
		  				<tr>
		  				<td align="center">
		  				Address:<input type="text" name="address" required="yes"></input>
		  				</td>
		  		</tr>
		 	<tr align="center">
		 		 <td align="center">
		 		 		<input  class="button" type="submit" value="Upload Image"/>
		 		 </td>
		 	</tr>
		 	
		 	</form>
		 	</table>
		</div>
		
	</div>
</div>

<%		
		
	
	
	}
	if(no==222)
	{
		%>
		<div class="success" id="message" style="position: absolute;top:300px;left:100px;">	
			<p>Face Image Added Successfully.....</p>
		</div>				
<%
	}
	%>

</div>	

</body>
</html>