package control.page;

import entity.OrderEntity;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "OrderManagerController"  , urlPatterns = "/loadOrder")
public class OrderManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        OrderEntity oe = new OrderEntity();
        Collection<Order> userOrderList = oe.getAllOrder();


        request.setAttribute("userOrderList", userOrderList);
        request.getRequestDispatcher("OrderManager.jsp").forward(request,response);
    }
}
