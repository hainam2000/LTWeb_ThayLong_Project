package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckoutController", urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shipping = request.getParameter("shipping");
        String payment = request.getParameter("payment");

        if(shipping != null) {
            if(shipping.equalsIgnoreCase("tietkiem")) {

            } else if(shipping.equalsIgnoreCase("nhanh")) {

            } else if(shipping.equalsIgnoreCase("antoan")) {

            }
        }
        if(payment != null) {
            if(payment.equalsIgnoreCase("cod")) {

            } else if(payment.equalsIgnoreCase("momo")) {

            } else if(payment.equalsIgnoreCase("bank")) {

            }
        }

        response.sendRedirect("checkout.jsp");
    }
}
