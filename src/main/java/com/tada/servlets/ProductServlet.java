/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.servlets;

import com.tada.beans.Product;
import com.tada.dao.ProductDAO;
import com.tada.dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pDAO = new ProductDAO();
        CategoryDAO cDAO = new CategoryDAO();
        String forward = "";
        String action = request.getParameter("action");
        
        switch (action.toLowerCase().trim()) {
            case "all":
                request.setAttribute("products", pDAO.list());
                forward = "/products/index.jsp";
                break;
            case "create":
                request.setAttribute("test", "this is not a test");
                request.setAttribute("categories", cDAO.findAll());
                forward = "/products/create.jsp";
                break;
            case "edit":
                
                break;
            case "delete":
                
                break;
            default:

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pDAO = new ProductDAO();
        Product product = new Product(request.getParameter("name"),
                BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))),
                Integer.parseInt(request.getParameter("category")), 
                request.getParameter("description").trim(), 
                Integer.parseInt(request.getParameter("stock")));
        pDAO.insert(product);
        response.sendRedirect(request.getContextPath()+"/products?action=all");
    }
}
