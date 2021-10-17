
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
        HttpSession session = request.getSession();
        if ((logout != null) ) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        }
        if((request.getSession().getAttribute("username") != null)) {
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
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
            AccountService user = new AccountService();    
            
                if ((user.login(username, password)) != null)
                {
                    HttpSession session = request.getSession();
                    
                    session.setAttribute("username", username);
                    response.sendRedirect("home");
                    return;
                }
                else 
                {
                  request.setAttribute("message", "Invalid login"); 
                  getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                  return;
                }
            }
        
    }


}
