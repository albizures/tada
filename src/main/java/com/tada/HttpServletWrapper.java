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
    protected final String DELETE_ACTION = "DELETE";
    protected final String PUT_ACTION = "PUT";
    protected final String POST_ACTION = "POST";
    
    private User getSessionUser (HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        Object idUserAttribute = session.getAttribute("idUser");
        if (idUserAttribute == null) {
            return null;
        }
        int idUser = (int)idUserAttribute;
        return userDAO.get(idUser);
    }
    
    protected boolean isValidSession (HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return false;
        }
        return user.isValid();
    }
    
    protected boolean isValidAdminSession (HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return false;
        }
        return user.isValid() && user.isAdmin();
    }

    protected void render404 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/404.jsp").forward(request, response);
    }
    
    protected void renderLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    protected String getType (HttpServletRequest request) {
        String actionType = request.getParameter("actionType");
        if (actionType == null) {
            return POST_ACTION;
        }
        
        switch (actionType) { // to avoid any unknow type
            case DELETE_ACTION:
            case PUT_ACTION:
            case POST_ACTION:
                return actionType;
            default:
                return POST_ACTION;
        }
    }
    
    protected boolean isPost (HttpServletRequest request) {
        if (POST_ACTION.equals(getType(request))) {
            return true;
        }
        
        return false;
    }
    
    protected boolean isPut (HttpServletRequest request) {
        if (PUT_ACTION.equals(getType(request))) {
            return true;
        }
        
        return false;
    }
    
    protected boolean isDelete (HttpServletRequest request) {
        if (DELETE_ACTION.equals(getType(request))) {
            return true;
        }
        
        return false;
    }
}
