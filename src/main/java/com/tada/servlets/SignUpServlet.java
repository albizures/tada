
package com.tada.servlets;

import com.tada.beans.User;
import com.tada.dao.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUp", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        User user = new User(
            request.getParameter("first-name"),
            request.getParameter("last-name"),
            request.getParameter("address"),
            Integer.parseInt(request.getParameter("phone")),
            request.getParameter("password"),
            request.getParameter("email")
        );
        int result = userDAO.insert(user);
        if(result != 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        } else {
            doGet(request, response);
        }
    }
}
