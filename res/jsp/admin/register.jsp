<html>
<head>
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 
%>
<script type="text/javascript">
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
}
</script>
<style>
p 
{
	font-family: monospace;
	font-style: italic;
	font-variant: normal;
	font-weight: bolder;
	font-size: medium;
	line-height: 200%;
	word-spacing: 1.5ex;
	letter-spacing: 0.1ex;
	text-transform: capitalize;
	text-indent: 0ex;
	text-align:center;
	
	
} 
div
{
	border-top-style:dotted;
	border-right-style:solid;
	border-bottom-style:dotted;
	border-left-style:solid;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/button5.css" type="text/css"/>
</head>
<%
int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div id="message" class="success" style="position:absolute;top:310px;left:250px ">
	<p>Registration Done Successfully...!!</p>
</div>
<%}
if(no==2)
{%>
<div class="downarrowdiv" id="message" style="position:absolute;top:180px;left:280px">
	<p>OOP's Something Went Wrong ...!!</p>
</div>
<%}%>
<body onload="startTimer()">
<form enctype="multipart/form-data" action="<%=request.getContextPath() %>/RegisterAdmin" method="post">
<div class="gradientbuttons">
<ul>
<li><input type="submit" value="Add Admin" class="gradientbuttons" ></input></li>
</ul>
</div>
<table align="center" style="border-right-style:solid;border-bottom-style:dotted;border-left-style:solid;">
<div>
	<tr><td><p id="al">User ID:</td><td><input type="text" name="userid" required="yes"></input></td></tr> </p>
	<tr><td><p id="al">User Password :</td><td><input type="text" name="pass" required="yes"></input></td></tr> </p>
	<tr><td><p id="al">User Name :</td><td><input type="text" name="name" required="yes"></input></td></tr> </p>
	<tr><td><p id="al">User Address :</td><td><input type="text" name="add" required="yes" ></input></td></tr> </p>
	<!-- <tr><td><p id="al">User City :</td><td><input type="text" name="city" required="yes"></input></td></tr> </p>
	<tr><td><p id="al">User State :</td><td><input type="text" name="state" required="yes"></input></td></tr></p> -->
	<tr><td><p id="al">User Cell :</td><td><input type="text" name="cell" required="yes"></input></td></tr></p>
	<tr><td><p id="al">User E-Mail :</td><td><input type="text" name="email" required="yes"></input></td></tr></p>
	<tr><td><p id="al"><input type="file" name="file" required="yes"></input></td></tr></p>
</div>
</table>
</form>
</body>
</html>