package control.cart;

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

@WebServlet(name = "RemoveProductController", urlPatterns = "/cart/removeon")
public class RemoveProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID = request.getParameter("pid");
        ProductEntity pe = new ProductEntity();
        HttpSession session = request.getSession();
        Product p = pe.getProductWithID(productID);
        Cart cart = Cart.getCartSession(session);
        if(productID == null || p == null)
            request.getRequestDispatcher("/Index").forward(request,response);
        else if(productID != null) {
            cart.removeOneQuantityProduct(productID);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/cart");
        }
    }
}
