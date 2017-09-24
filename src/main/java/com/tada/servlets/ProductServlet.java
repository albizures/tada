package com.tada.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tada.beans.Product;
import com.tada.dao.ProductDAO;
import com.tada.dao.CategoryDAO;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                request.setAttribute("categories", cDAO.findAll());
                forward = "/products/create.jsp";
                break;
            case "edit":
                request.setAttribute("product", pDAO.get(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("categories", cDAO.findAll());
                forward = "/products/edit.jsp";
                break;
            case "delete":
                
                break;
            default:

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }

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
