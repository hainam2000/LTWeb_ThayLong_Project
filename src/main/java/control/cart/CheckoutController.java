package control.cart;

import entity.ShippingEntity;
import model.Cart;
import model.Shipping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CheckoutController", urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart c = Cart.getCartSession(session);
        ShippingEntity shippingEntity = new ShippingEntity();

        Collection<Shipping> shippingList = shippingEntity.getAllShipping();
        request.setAttribute("shippingList", shippingList);
        String shipping = request.getParameter("shipping");
        if(shipping != null) {
            Shipping shippingByName = shippingEntity.getShippingByName(shipping);
            c.setShippingPrice(shippingByName);
            c.commit(session);
        }
        request.getRequestDispatcher("checkout.jsp").forward(request,response);
    }
}
