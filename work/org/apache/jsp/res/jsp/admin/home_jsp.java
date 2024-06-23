package org.apache.jsp.res.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 String adminName=session.getAttribute("aid").toString(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write(" <title>Face Recognition Attendance System</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/demo.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style1.css\" />\r\n");
      out.write("        <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/fontstyle.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("window.history.forward();\r\n");
      out.write("function noBack() { window.history.forward(); }\r\n");
      out.write("</script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("         <h1>Face Recognition Attendance System</h1>\r\n");
      out.write("            <!-- <h1>Feature Match: A General ANNF Estimation<span> Technique and its Applications</span></h1> -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("               \r\n");
      out.write("                <span class=\"right\">\r\n");
      out.write("                    <a href=\"#\" target=\"_blank\">Welcome....!</a>\r\n");
      out.write("                    <a href=\"#\"><strong>");
      out.print(adminName);
      out.write(" </strong></a>\r\n");
      out.write("                </span>\r\n");
      out.write("                <div class=\"clr\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                \r\n");
      out.write("                <ul class=\"ca-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/profile.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">U</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Profile</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">View Profile</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() );
      out.write("/ClassificationList?action=get\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">I</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Category</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Add Category</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/upload2.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">I</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Upload Image</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">UnTrained</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/list_category.jsp\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">D</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">View Image</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">View</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/jsp/user/imageSearch.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">I</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Attendance</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Mark Attendance</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                 \r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/attendance.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">Q</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">View Attendance</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Attendance</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/users.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">Q</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">User List</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">View</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/jsp/user/feedback.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">I</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Register Feedback</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Feedback</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/changepass.jsp?no=0\" target=\"f\">\r\n");
      out.write("                            <span class=\"ca-icon\">S</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Change Password</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Change Pass</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp?no=6\">\r\n");
      out.write("                            <span class=\"ca-icon\">X</span>\r\n");
      out.write("                            <div class=\"ca-content\">\r\n");
      out.write("                                <h2 class=\"ca-main\">Log Out</h2>\r\n");
      out.write("                                <h3 class=\"ca-sub\">Log Out</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                   \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div><!-- content -->\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("           <div style=\"position: absolute;top: 160px;left: 230px;\"><iframe width=\"750px;\" height=\"520px;\" name=\"f\"  frameborder=\"0\" scrolling=\"auto\"></iframe></div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("    </body>\r\n");
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
