package com.tada.servlets;

import com.tada.HttpServletWrapper;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tada.beans.Product;
import com.tada.beans.Image;

import com.tada.dao.ProductDAO;
import com.tada.dao.CategoryDAO;
import com.tada.dao.ImageDAO;

@WebServlet(name = "ProductsServlet", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServletWrapper {
    final CategoryDAO categoryDAO = new CategoryDAO();
    final ProductDAO productDAO = new ProductDAO();
    final ImageDAO imageDAO = new ImageDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!super.isValidAdminSession(request)) {
            super.render404(request, response);
            return;
        }
        request.setAttribute("categories", categoryDAO.findAll());
        request.setAttribute("products", productDAO.findAll());

        String edit = request.getParameter("edit");
        if (edit != null) {
            Product product = productDAO.findById(Integer.parseInt(edit));
            if (product.isValid()) {
                request.setAttribute("product", product);
                
                request.setAttribute("edit", true);
            }
        }
        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (super.getType(request)) {
            case POST_ACTION:
                productDAO.insert(new Product(
                    request.getParameter("name"),
                    BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))),
                    Integer.parseInt(request.getParameter("category")),
                    request.getParameter("description").trim(), 
                    Integer.parseInt(request.getParameter("stock")),
                    imageDAO.insert(new Image(request.getParameter("url")))
                ));
                break;
            case PUT_ACTION:
                productDAO.update(new Product (
                    Integer.parseInt(request.getParameter("id")), 
                    request.getParameter("name"), 
                    new BigDecimal(Double.parseDouble(request.getParameter("price"))), 
                    Integer.parseInt(request.getParameter("category")), 
                    request.getParameter("description").trim(), 
                    Integer.parseInt(request.getParameter("stock")),
                    imageDAO.insert(new Image(request.getParameter("url")))
                ));
                break;
            case DELETE_ACTION:
                productDAO.delete(Integer.parseInt(request.getParameter("id")));
                break;
            default:
        }
        response.sendRedirect("/products");
    }
    
}
