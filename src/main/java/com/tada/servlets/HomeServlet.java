package com.tada.servlets;

import com.tada.dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HomeServlet", urlPatterns = {"/index.html"})
public class HomeServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productDAO.findAll());
        System.out.println("HAHAHAHAHAHAHAHAHAHAHAHAHAHA" + request.getRequestURL());
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
