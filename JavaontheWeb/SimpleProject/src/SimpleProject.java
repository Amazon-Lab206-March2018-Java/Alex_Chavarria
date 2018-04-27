

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleProject
 */
@WebServlet("/SimpleProject")
public class SimpleProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the value for the query parameter
        String userName = request.getParameter("name");
        String userLanguage = request.getParameter("language");
        String userHometown = request.getParameter("hometown");
        if (userName == null)
        	userName = "Unknown";
    	if (userLanguage == null)
    		userLanguage = "Unknown";
		if (userHometown == null)
			userHometown = "Unknown";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Hello World, from " + userName + "</h1>");
        out.write("<h3>Your favorite language is: " + userLanguage + "</h3>");
        out.write("<h3>Your hometwon is: " + userHometown + "</h3>");
	    }
	//...
}
