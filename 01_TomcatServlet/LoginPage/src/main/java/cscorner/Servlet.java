package cscorner;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(
    name = "servlet",
    description = "Login Servlet Testing",
    urlPatterns = { "/servlet" },
    initParams = {
        @WebInitParam(name = "user", value = "Raju"),
        @WebInitParam(name = "password", value = "Welcome@2025")
    }
)
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        if (!user.matches("^[A-Z][a-zA-Z]{3,}$")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color='red'>Invalid name format. Name must start with a capital letter and have at least 3 characters.</font>");
            rd.include(request, response);
            return;
        }
//            if (!pwd.matches("^(?=.[A-Z])(?=.\\\\d)(?=.[!@#$%^&()+=-])[A-Za-z\\\\d!@#$%^&*()+=-]{8,}$")) {
    	if (!pwd.matches("^(?=.[A-Z])(?=.\\d)(?=.[!@#$%^&()+=-])[A-Za-z\\d!@#$%^&*()+=-]{8,}$")) {

          	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
          	    PrintWriter out = response.getWriter();
          	    out.println("<font color='red'>Invalid password format. It must have:<br>"
          	        + "• At least 8 characters<br>"
          	        + "• At least 1 uppercase letter<br>"
          	        + "• At least 1 digit<br>"
          	        + "• At least 1 special character</font>");
          	    rd.include(request, response);
          	    return;
            }
          	
        // Get init parameters
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        
        if(userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color='red'>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}