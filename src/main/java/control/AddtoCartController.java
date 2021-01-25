package control;

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

@WebServlet(name = "AddtoCart", urlPatterns = "/cart/add")
public class AddtoCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID = request.getParameter("pid");
        String userID = request.getParameter("userID");
        ProductEntity pe = new ProductEntity();
        HttpSession session = request.getSession();
        Product p = pe.getProductWithID(productID);
        Cart cart = Cart.getCartSession(session);

        if(productID == null || p == null)
            request.getRequestDispatcher("/Index").forward(request,response);
        else if(cart.isContain(p)){
            cart.addProduct(p);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/cart");
        } else {
            cart.addProduct(p);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/Index");
        }
    }
}
