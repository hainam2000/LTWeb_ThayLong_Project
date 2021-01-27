package control.cart;

import entity.OrderEntity;
import entity.UserEntity;
import model.Cart;
import model.Mail;
import tools.MailUtils;

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
        String orderID = oe.getUnpaidOrder(userID);


        String subject = "Thanh toán thành công!";
        String details = "Tên \t\t\t\t\t\t Số lượng \t Giá \t Thành tiền \t Ngày\n";
        String productList = oe.getAllOrderDetail(orderID, userID);
        String totalPrice = "===================== \nTổng đơn hàng: " + oe.getTotalPrice(orderID, userID);
        String body = "Cảm ơn bạn đã tin tưởng dịch vụ của chúng tôi! \nDưới đây là thông tin đơn hàng " + orderID + " của bạn!\n" + details + productList + totalPrice;

        Mail mailsend = new Mail(userMail, subject, body);

        if(userID != null) {
            if(oe.isExistBlankOrder(userID)) {
                oe.addProductToOrderDetails(c.getAllProduct(), userID);
                oe.changeOrderStatus(userID,c.getTotalPrice());
                oe.createOrder(userID);
                c.removeAll();
                c.commit(session);
                MailUtils.sendMail(mailsend);
//                System.out.println(body);
                response.sendRedirect("Index");
            } else {
                oe.createOrder(userID);
                oe.addProductToOrderDetails(c.getAllProduct(), userID);
                oe.changeOrderStatus(userID,c.getTotalPrice());
                oe.createOrder(userID);
                c.removeAll();
                c.commit(session);
                MailUtils.sendMail(mailsend);
//                System.out.println(body);
                response.sendRedirect("Index");
            }
        }

    }
}
