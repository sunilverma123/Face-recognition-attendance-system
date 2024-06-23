<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<% String adminName=session.getAttribute("aid").toString(); %>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Face Recognition Attendance System</title>

        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css" />
        <link href="<%=request.getContextPath() %>/css/fontstyle.css" rel='stylesheet' type='text/css' />
    
    <script type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }
</script>
    </head>
    <body>
        <div class="container">
         <h1>Face Recognition Attendance System</h1>
            <!-- <h1>Feature Match: A General ANNF Estimation<span> Technique and its Applications</span></h1> -->

<div class="header">
               
                <span class="right">
                    <a href="#" target="_blank">Welcome....!</a>
                    <a href="#"><strong><%=adminName%> </strong></a>
                </span>
                <div class="clr"></div>
            </div>
            <div class="content">
                
                <ul class="ca-menu">
                    <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/profile.jsp?no=0" target="f">
                            <span class="ca-icon">U</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Profile</h2>
                                <h3 class="ca-sub">View Profile</h3>
                            </div>
                        </a>
                    </li>
                    
                    
                    <li>
                        <a href="<%=request.getContextPath() %>/ClassificationList?action=get" target="f">
                            <span class="ca-icon">I</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Category</h2>
                                <h3 class="ca-sub">Add Category</h3>
                            </div>
                        </a>
                    </li>
                     <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/upload2.jsp?no=0" target="f">
                            <span class="ca-icon">I</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Upload Image</h2>
                                <h3 class="ca-sub">UnTrained</h3>
                            </div>
                        </a>
                    </li>
                    
                    <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/list_category.jsp" target="f">
                            <span class="ca-icon">D</span>
                            <div class="ca-content">
                                <h2 class="ca-main">View Image</h2>
                                <h3 class="ca-sub">View</h3>
                            </div>
                        </a>
                    </li>
                    
                    
                     <li>
                        <a href="<%=request.getContextPath() %>/res/jsp/user/imageSearch.jsp?no=0" target="f">
                            <span class="ca-icon">I</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Attendance</h2>
                                <h3 class="ca-sub">Mark Attendance</h3>
                            </div>
                        </a>
                    </li>
                 
                     <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/attendance.jsp?no=0" target="f">
                            <span class="ca-icon">Q</span>
                            <div class="ca-content">
                                <h2 class="ca-main">View Attendance</h2>
                                <h3 class="ca-sub">Attendance</h3>
                            </div>
                        </a>
                    </li>
                    
                    <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/users.jsp?no=0" target="f">
                            <span class="ca-icon">Q</span>
                            <div class="ca-content">
                                <h2 class="ca-main">User List</h2>
                                <h3 class="ca-sub">View</h3>
                            </div>
                        </a>
                    </li>
                    
                    
                   
                    
                     <li>
                        <a href="<%=request.getContextPath() %>/res/jsp/user/feedback.jsp?no=0" target="f">
                            <span class="ca-icon">I</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Register Feedback</h2>
                                <h3 class="ca-sub">Feedback</h3>
                            </div>
                        </a>
                    </li>
                    
                     <li>
                        <a href="<%=request.getContextPath()%>/res/jsp/admin/changepass.jsp?no=0" target="f">
                            <span class="ca-icon">S</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Change Password</h2>
                                <h3 class="ca-sub">Change Pass</h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/index.jsp?no=6">
                            <span class="ca-icon">X</span>
                            <div class="ca-content">
                                <h2 class="ca-main">Log Out</h2>
                                <h3 class="ca-sub">Log Out</h3>
                            </div>
                        </a>
                    </li>
                   
                </ul>
            </div><!-- content -->
            
            
           <div style="position: absolute;top: 160px;left: 230px;"><iframe width="750px;" height="520px;" name="f"  frameborder="0" scrolling="auto"></iframe></div>
            
        </div>
       
    </body>
</html>