package tools;

import entity.OrderEntity;
import model.Mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

public class MailUtils {
    private static final String myEmail = "p.thieenlong.304@gmail.com";
    private static final String myPassword = "iuNgocHa";
    private static Properties props = new Properties();
    static {
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.starttls.enable", "true");
    }
    public static void sendMail(Mail mailsend){
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail, myPassword);
                }
            });

            Message message = prepareMessage(session, mailsend);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private static Message prepareMessage(Session session, Mail mail) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(mail.getFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getBody());
            return message;
        } catch (Exception e) {
            return null;
        }
    }

    public void sendPaidMail(String mail, String userID, String orderID) {
        OrderEntity oe = new OrderEntity();
        if(mail != null && userID != null && orderID != null) {
            String sub = "Thanh toán thành công!";
            String body = "Cảm ơn bạn đã tin tưởng dịch vụ của chúng tôi! \nDưới đây là thông tin đơn hàng " + orderID + " của bạn!\n";
            String productList = oe.getAllOrderDetail(orderID, userID);
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
