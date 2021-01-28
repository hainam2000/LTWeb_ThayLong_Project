package control.user;

import entity.OrderEntity;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "userLoadOrder", urlPatterns = "/order")
public class userLoadOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userID = request.getParameter("id");
        OrderEntity oe = new OrderEntity();
        if(userID != null) {
            Collection<Order> userOrderList = oe.getAllOrderByUserID(userID);
            request.setAttribute("userOrderList", userOrderList);
            request.getRequestDispatcher("order.jsp").forward(request,response);
        } else response.sendRedirect("404.jsp");
    }
}
