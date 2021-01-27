package control;

import entity.ProductEntity;
import model.Cart;
import model.Product;
import tools.Utils;

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
        Cart cart = Cart.getCartSession(session);
        System.out.println(productID);
        System.out.println(Utils.changeStringToInt(quantity));
        if(productID != null && Utils.changeStringToInt(quantity) > 0)  {
            cart.updateProduct(productID, quantity);
            System.out.println(cart.getTotalPrice());
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/cart");
        } else System.out.println("error");
    }
}
