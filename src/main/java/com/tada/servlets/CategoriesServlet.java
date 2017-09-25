package com.tada.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tada.HttpServletWrapper;
import com.tada.dao.CategoryDAO;
import com.tada.beans.Category;

@WebServlet(name = "Categories", urlPatterns = {"/categories"})
public class CategoriesServlet extends HttpServletWrapper {
    final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.findAll());
        String edit = request.getParameter("edit");
        if (edit != null) {
            Category category = categoryDAO.findById(Integer.parseInt(edit));
            if (category.isValid()) {
                request.setAttribute("category", category);
                request.setAttribute("edit", true);
            }  
        }
        request.getRequestDispatcher("/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (super.getType(request)) {
            case POST_ACTION:
                categoryDAO.insert(new Category(request.getParameter("name")));
                break;
            case PUT_ACTION:
                categoryDAO.update(new Category (
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name")
                ));
                break;
            case DELETE_ACTION:
                categoryDAO.delete(Integer.parseInt(request.getParameter("id")));
                break;
            default:
        }

        response.sendRedirect("/categories");
    }
}
