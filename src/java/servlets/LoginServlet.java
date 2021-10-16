
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.*;


public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String logout = request.getParameter("logout");
        
        if ((logout == null) ) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        return;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
            if (username == null || username.equals("") || password == null || password.equals("") ) {
            //set up a helpful error message for the user.
            request.setAttribute("message", "Invalid login");
            //display the form again.
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            }
            else {
                 User user = new User(username, password);
                user.login(username, password);
            }
        
    }


}
