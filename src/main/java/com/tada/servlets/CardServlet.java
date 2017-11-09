/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.servlets;

import com.tada.HttpServletWrapper;
import com.tada.beans.Card;
import com.tada.dao.CardDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick
 */
@WebServlet(name = "CardServlet", urlPatterns = {"/cards"})
public class CardServlet extends HttpServletWrapper {
    //
    private CardDAO dao = new CardDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(super.isValidSession(request)){
            request.setAttribute("cards", dao.findByUser(Integer.parseInt(session.getAttribute("idUser").toString())));
            request.getRequestDispatcher("/cards.jsp").forward(request, response);
        } else {
            System.out.println("entro al else");
            super.renderLogin(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(super.isValidSession(request)){
            switch(super.getType(request)){
                case POST_ACTION:
                    dao.insert(new Card(request.getParameter("name"), 
                                    Integer.parseInt(request.getParameter("number")), 
                                    Integer.parseInt(request.getParameter("month")), 
                                    Integer.parseInt(request.getParameter("year")), 
                                    Integer.parseInt(session.getAttribute("idUser").toString())));
                    break;
                case PUT_ACTION:
                    dao.update(new Card(Integer.parseInt(request.getParameter("id")),request.getParameter("name"), 
                                    Integer.parseInt(request.getParameter("number")), 
                                    Integer.parseInt(request.getParameter("month")), 
                                    Integer.parseInt(request.getParameter("year")), 
                                    Integer.parseInt(session.getAttribute("idUser").toString())));
                    break;
                case DELETE_ACTION:
                    dao.delete(Integer.parseInt(request.getParameter("id")));
                    break;
            }
            response.sendRedirect("/cards");
        } else {
            super.renderLogin(request, response);
        }
    }
}
