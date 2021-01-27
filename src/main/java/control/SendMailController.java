package control;

import entity.OrderEntity;
import tools.MailUtils;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "SendMailController", urlPatterns = "/sendmail")
public class SendMailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MailUtils mu = new MailUtils();
//        OrderEntity oe = new OrderEntity();
//
//        String userMail = request.getParameter("mail");
//        String userName = request.getParameter("name");
//
//
//        if(userMail != null && userName != null && orderID != null) {
//            String sub = "Thanh toán thành công!";
//            String mess = "Cảm ơn " + userName + " đã tin tưởng dịch vụ của chúng tôi! \nDưới đây là thông tin đơn hàng " + orderID + " của bạn!\n";
//            String productList = oe.getAllOrderDetail(orderID, userName);
//            try {
//                mu.sendEmail(userMail, sub, mess, productList);
//                response.sendRedirect("Index");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

}
