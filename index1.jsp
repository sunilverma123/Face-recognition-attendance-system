<%@page import="com.util.Utility"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Face Recognition Attendance System</title>
   
    <link href="<%=request.getContextPath() %>/css2/style.css" rel="stylesheet" type="text/css" /> 
    <link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
  </head>

  <body onload="startTimer()" bgcolor="white">
  <center>
  <div style="position:absolute;top:20px;left:150px">
  <IMG SRC="images/project_title.png" width="100%" height="50%" BORDER="0" top="40" ALT="" align="middle">
  </div>
  </center>
    <div class="box">
    <form action="<%=request.getContextPath()%>/UserLogin" method="post">	
      <h1>User Login</h1>
      <input type="text" name="username" placeholder="Username" required />
      <input type="password" name="password" placeholder="Password" required>
      <button>Login</button>
      <!-- <p>Not a member? <span>Sign Up</span></p> -->
      <center>
     <a href="<%=request.getContextPath() %>/index.jsp"> [Are You Admin?] </a> <!-- &nbsp;&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;&nbsp; -->
    <a href="<%=request.getContextPath()%>/signup.jsp" style="font-size: 17px; ">New User..?</a>
      </center>
      </form>
    </div>
  </div>
</div>


<%
		int noo=Utility.parse(request.getParameter("no"));
		if(noo==1)
{
%>
		
			
			<div class="error" id="message" style="position: absolute;top:110px; left:520px;">
			<p>Opp's,your Id or password is wrong ..!</p>
			</div>	
		
			
<%
}
%>

<%-- <%

if(noo==2)
{
%>
		
			
			<div class="error" id="message" style="position: absolute;top:110px; left:520px;">
			<p> User Category is not available..!</p>
			</div>	
		
			
<%
}
%> --%>


  </body>
</html>