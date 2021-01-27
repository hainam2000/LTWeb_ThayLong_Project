package control.cart;

import entity.OrderEntity;
import model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PaymentController", urlPatterns = "/payment")
public class PaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart c = Cart.getCartSession(session);
        OrderEntity oe = new OrderEntity();
        String userID = request.getParameter("userID");

        if(userID != null) {
            oe.addProductToOrderDetails(c.getAllProduct(), userID);

        }



        response.sendRedirect("payment.jsp");
    }
}
