package control.account;

import entity.UserEntity;
import model.Mail;
import tools.MailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "ForgotPasswordController", urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        UserEntity ue = new UserEntity();


        String subject = "Quên mật khẩu";
        String pass = ue.getUserPassword(username, mail);
        String body = "Mật khẩu của bạn là: " + pass;
        Mail mailsend = new Mail(mail, subject, body);

        if(mail != null && username != null) {
            MailUtils.sendMail(mailsend);
            response.sendRedirect("Index");
        } else response.sendRedirect("404.jsp");

//        if(mail!= null && username != null) {
//            mailsend.setTo(mail);
//            mailsend.setSubject("Quên mật khẩu");
//            mailsend.setBody("Mật khẩu của bạn là: " + ue.getUserPassword(username, mail));
//
//            try {
//                MailUtils.sendMail(mailsend);
//                request.getRequestDispatcher("Index").forward(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else System.out.println("ERROR");
    }
}
