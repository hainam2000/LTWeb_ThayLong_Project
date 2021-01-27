package control.cart;

import entity.OrderEntity;
import entity.UserEntity;
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
        UserEntity ue = new UserEntity();
        String userID = request.getParameter("userID");
        String userMail = request.getParameter("userMail");
        String mail;
        if(userMail != null) {
            mail = ue.getUserMail(userID);
        }

        if(userID != null) {
            if(oe.isExistBlankOrder(userID)) {
                oe.addProductToOrderDetails(c.getAllProduct(), userID);
                oe.changeOrderStatus(userID,c.getTotalPrice());
                oe.createOrder(userID);
                c.removeAll();
                c.commit(session);
                response.sendRedirect("payment.jsp");
            } else {
                oe.createOrder(userID);
                oe.addProductToOrderDetails(c.getAllProduct(), userID);
                oe.changeOrderStatus(userID,c.getTotalPrice());
                oe.createOrder(userID);
                c.removeAll();
                c.commit(session);
                response.sendRedirect("payment.jsp");
            }
        }
    }
}
