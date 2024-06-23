package org.apache.jsp.res.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.AdminDAO;
import com.util.Utility;

public final class imageSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	int no = 0,no1=0;
	String fileName = "";

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    \r\n");
      out.write("    <title>Face Recognition Attendance System</title>\r\n");
      out.write("    \r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/form.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/style.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.6.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div class=\"container\" id=\"label\" style=\"position:absolute;top:7px;left:150px;width:550px;height:440px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
	
	no = Utility.parse(request.getParameter("no"));
	no1 = Utility.parse(request.getParameter("no1"));
	if(no==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t<p>Face Image Searching Process Done Successfully.....</p>\r\n");
      out.write("\t\t</div>\t\t\t\t\r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong While image1 Comparison!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}
	if(no==4)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong While image2 Comparison!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}
	if(no==0 & no1==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t<p>Requested Process Done Successfully.....</p>\r\n");
      out.write("\t\t</div>\t\t\t\t\r\n");

	}
	if(no==0 & no1==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t</div>\t\r\n");

	}

      out.write("\r\n");
      out.write("   \r\n");
      out.write("<div class=\"TabMenu\" style=\"position: relative;left:0px;text-align: center;\">\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/search.png\" height=\"50\" width=\"50\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t</span>\r\n");
      out.write("\t<h2 style=\"color: #000000\">Search Image to Mark Attendance<h2>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<hr size=\"10\" color=\"#351616\"></hr>\r\n");
      out.write("\r\n");

	if( no == 0)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"ContentFrame\">\r\n");
      out.write("\t<div class=\"AllTabs\">\r\n");
      out.write("\t\t<div class=\"TabContent\" style=\"position: relative;width: 550px;\">\r\n");
      out.write("\t\t <table align=\"center\" id=\"login\">\r\n");
      out.write("\t\t   <form action=\"");
      out.print(request.getContextPath());
      out.write("/SearchFileAction\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t  \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t  \t\t\t\t\t<!-- <p><h2 style=\"color: #000000\">Search Iris Image Files</h2> -->\r\n");
      out.write("\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td style=\"color: #000000\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tBrowse Image File : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" name=\"myfile\" type=\"file\" required=\"yes\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr height=\"35px\"></tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\" colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t  \t\t\t\t\t <input class=\"button\" type=\"submit\" value=\"Search Image\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t</form>\t\r\n");
      out.write("\t\t </table>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");

	}// Ends  if(no == 0)
	else if(no == 11)
	{
		fileName = (String)request.getAttribute("image_name");
		System.out.println("===user side===="+fileName);
		

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"ContentFrame\">\r\n");
      out.write("\t<div class=\"AllTabs\">\r\n");
      out.write("\t\t<div class=\"TabContent\" style=\"position: relative;width: 550px;\">\r\n");
      out.write("\t\t  <table align=\"center\" id=\"login\">\r\n");
      out.write("\t\t    <form action=\"");
      out.print(request.getContextPath());
      out.write("/SearchImage\" method=\"post\">\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t \t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/File/uploadedImg/");
      out.print(fileName );
      out.write("\" height=\"200\" width=\"200\" />\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr height=\"10px\"></tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t <td align=\"center\">\r\n");
      out.write("\t\t \t\t \t\t<input  class=\"button\" type=\"submit\" value=\"Search Image\"/>\r\n");
      out.write("\t\t \t\t </td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t</form>\r\n");
      out.write("\t\t \t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
		
		
	}
	else if(no == 22)
	{
		
		
		 String cid = AdminDAO.getClasificationId();
		 String cri_name = AdminDAO.getClasificationId2();
		 String c_address = AdminDAO.getClasificationId3(); 
		 
		 AdminDAO.updateAttendance(cri_name); // updating attendance
		 
		    
		    String cName=AdminDAO.getClassificationName(cid);

      out.write("\r\n");
      out.write("\t<div class=\"ContentFrame\">\r\n");
      out.write("\t<div class=\"AllTabs\">\r\n");
      out.write("\t\t<div class=\"TabContent\" style=\"position: relative;width: 550px;\">\r\n");
      out.write("\t\t  <table align=\"center\" id=\"login\">\r\n");
      out.write("\t\t    <form action=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/user/view_file.jsp\" method=\"post\">\r\n");
      out.write("\t\t \t<input type=\"hidden\" name=\"cid\" value=\"");
      out.print(cid);
      out.write("\">\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t \t\t\t\t\t<font color=\"#003366\" size=\"6\">Image Retrieval Information </font>\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t \t\t\t\t\t<font color=\"#FF00FF\" size=\"4\">Result</font>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td width=\"20px\" align=\"center\">:</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"black\" size=\"4\">");
      out.print(cName);
      out.write("</font>\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t <tr align=\"center\">\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t \t\t\t\t\t<font color=\"#FF00FF\" size=\"4\">Name</font>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td width=\"20px\" align=\"center\">:</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"black\" size=\"4\">");
      out.print(cri_name);
      out.write("</font>\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t \t\t\t\t\t<font color=\"#FF00FF\" size=\"4\">Address</font>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td width=\"20px\" align=\"center\">:</td>\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"black\" size=\"4\">");
      out.print(c_address);
      out.write("</font>\r\n");
      out.write("\t\t \t\t\t</td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t \r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr height=\"10px\"></tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t<tr align=\"center\">\r\n");
      out.write("\t\t \t\t <td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t \t\t \t\t<input  class=\"button\" type=\"submit\" value=\"View Image\"/>\r\n");
      out.write("\t\t \t\t </td>\r\n");
      out.write("\t\t \t</tr>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t</form>\r\n");
      out.write("\t\t \t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
		
		
	}
	if(no==22)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position: absolute;top: 40px;left:100px;\">\t\r\n");
      out.write("\t\t\t<p>Face Image Searching Process Done Successfully.....</p>\r\n");
      out.write("\t\t</div>\t\t\t\t\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
