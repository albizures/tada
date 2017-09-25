package com.tada.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tada.HttpServletWrapper;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServletWrapper {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!super.isValidSession(request)) {
            super.render404(request, response);
            return;
        }
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
