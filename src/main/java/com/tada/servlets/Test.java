package com.tada.servlets;

import com.tada.beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Test", urlPatterns = {"/test"})
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Hello World";
        request.setAttribute("message", message); // This will be available as ${message}
        User user = User.getUserById(1);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/test.jsp").forward(request, response);
        
    }
}
