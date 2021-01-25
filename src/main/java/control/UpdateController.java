package control;

import entity.ProductEntity;
import model.Cart;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateController", urlPatterns = "/cart/update")
public class UpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID = request.getParameter("pid");
        String quantity = request.getParameter("quantity");
        HttpSession session = request.getSession();
        if (productID != null) {
            Cart cart = Cart.getCartSession(session);
            cart.updateProduct(productID, quantity);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/cart");
        } else response.sendRedirect("/LTWeb_war_exploded/Index");
    }
}
