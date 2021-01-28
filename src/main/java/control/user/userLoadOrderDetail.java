package control.user;

import entity.OrderEntity;
import model.OrderDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "userLoadOrderDetail", urlPatterns = "/orderdetails")
public class userLoadOrderDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        OrderEntity oe = new OrderEntity();
        Collection<OrderDetail> orderDetails = oe.getAllOrderDetailsByOrderID(oid);
        String totalPrice = oe.getTotalPrice(oid);

        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("orderdetails.jsp").forward(request,response);
    }
}
