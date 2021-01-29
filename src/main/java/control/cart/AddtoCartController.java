package control.cart;

import entity.OrderEntity;
import entity.ProductEntity;
import entity.UserEntity;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddtoCartController", urlPatterns = "/cart/add")
public class AddtoCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID = request.getParameter("pid");
        ProductEntity pe = new ProductEntity();
        HttpSession session = request.getSession();
        Product p = pe.getProductWithID(productID);
        Cart cart = Cart.getCartSession(session);
        if(productID == null ) {
            response.sendRedirect("404.jsp");
        } else {
            cart.addProduct(p);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/Index");
        }
    }
}
