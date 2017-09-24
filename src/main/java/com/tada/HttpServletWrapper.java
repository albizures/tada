package com.tada;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tada.dao.UserDAO;
import com.tada.beans.User;


public class HttpServletWrapper extends HttpServlet{
    protected final UserDAO userDAO = new UserDAO();
    protected boolean isValidSession (HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        Object idUserAttribute = session.getAttribute("idUser");
        if (idUserAttribute == null) {
            return false;
        }
        int idUser = (int)idUserAttribute;
        User user = userDAO.get(idUser);
        return user.isValidUser();
    }

    protected void render404 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/404.jsp").forward(request, response);
    }
}
