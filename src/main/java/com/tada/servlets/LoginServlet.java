package com.tada.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tada.dao.UserDAO;
import com.tada.beans.User;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userDAO.login(
            request.getParameter("email"),
            request.getParameter("password")
        );
        System.out.println(user);

        if (user.isValidUser()) {
            HttpSession session = request.getSession();
            session.setAttribute("idUser", user.getIdUser());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            response.sendRedirect("/");
            return;
        }
        request.setAttribute("error", true);
        doGet(request, response);
    }
}
