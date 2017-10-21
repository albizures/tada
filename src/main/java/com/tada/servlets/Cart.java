package com.tada.servlets;

import com.tada.beans.OrderList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Cart", urlPatterns = {"/cart"})
public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderList> cartList = (List<OrderList>) session.getAttribute("cartList");
        request.setAttribute("cartList", cartList);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        OrderList item;
        List<OrderList> cartList = (List<OrderList>) session.getAttribute("cartList");
        if(cartList == null){
            cartList = new ArrayList<>();
        }
        try {
            if(action.toLowerCase().equals("add")){
                item = new OrderList();
                item.setIdProduct(Integer.parseInt(request.getParameter("product")));
                cartList.add(item);
                session.setAttribute("cartList", cartList);
                response.getWriter().println("Producto agregado al carrito");
            } else if(action.toLowerCase().equals("remove")){
                System.out.println(request.getParameter("action"));
                cartList.remove(Integer.parseInt(request.getParameter("index")));
                request.setAttribute("cartList", cartList);
            }
        } catch(IOException ex){
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
