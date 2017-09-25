package com.tada.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tada.dao.CategoryDAO;
import com.tada.beans.Category;

@WebServlet(name = "Categories", urlPatterns = {"/categories"})
public class CategoriesServlet extends HttpServlet {
    final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.findAll());
        request.getRequestDispatcher("/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryDAO.insert(new Category(
            request.getParameter("name")
        ));
        response.sendRedirect("/categories");
    }
}
