/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.servlets;

import com.tada.HttpServletWrapper;
import com.tada.beans.Order;
import com.tada.dao.OrderDAO;
import com.tada.dao.OrderListDAO;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServletWrapper {
    private OrderDAO dao = new OrderDAO();
    private OrderListDAO dao1 = new OrderListDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(super.isValidSession(request)){
            switch(super.getType(request)){
                case POST_ACTION:
                    dao.insert(new Order(new Timestamp(System.currentTimeMillis()), 
                            Integer.parseInt(request.getParameter("card")), 
                            Integer.parseInt(session.getAttribute("idUser").toString()), 
                            1));
                    dao1.insert(null);
                    break;
                case PUT_ACTION:
                    break;
                case DELETE_ACTION:
                    break;
            }
            response.sendRedirect("/");
        } else{
            super.renderLogin(request, response);
        }
    }
}
