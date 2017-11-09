package com.tada.servlets;

import com.tada.HttpServletWrapper;
import com.tada.beans.OrderList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tada.beans.CartItem;
import com.tada.dao.CardDAO;
import java.math.BigDecimal;

@WebServlet(name = "Cart", urlPatterns = {"/cart"})
public class CartServlet extends HttpServletWrapper {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        if(!super.isValidSession(request)){
//            super.renderLogin(request, response);
//            return;
//        }
        HttpSession session = request.getSession();
        List<OrderList> cartList = (List<OrderList>) session.getAttribute("cartList");
        request.setAttribute("cartList", cartList);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        CartItem item;
        CardDAO dao = new CardDAO();
        List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
        if(cartList == null){
            cartList = new ArrayList<>();
        }
        try {
            if(action.toLowerCase().equals("add")){
                BigDecimal price = new BigDecimal(request.getParameter("price"));
                item = new CartItem(request.getParameter("name"),price);
                cartList.add(item);
                session.setAttribute("cartList", cartList);
                response.getWriter().println("Producto agregado al carrito");
            } else if(action.toLowerCase().equals("remove")){
                System.out.println(request.getParameter("action"));
                cartList.remove(Integer.parseInt(request.getParameter("index")));
                request.setAttribute("cartList", cartList);
            } else if(action.toLowerCase().equals("checkout")) {
                if(!super.isValidSession(request)){
                    super.renderLogin(request, response);
                } else {
                    request.setAttribute("cartListPayment", cartList);
                    request.setAttribute("cards", dao.findByUser(Integer.parseInt(session.getAttribute("idUser").toString())));
                    request.getRequestDispatcher("/checkout.jsp").forward(request, response);
                }
            }
        } catch(IOException ex){
                Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
