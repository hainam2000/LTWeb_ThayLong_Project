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

@WebServlet(name = "DeleteCartController", urlPatterns = "/cart/delete")
public class DeleteCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID = request.getParameter("pid");
        HttpSession session = request.getSession();
        if(productID == null)
            request.getRequestDispatcher("/Index").forward(request,response);
        else {
            Cart cart = Cart.getCartSession(session);
            cart.removeProduct(productID);
            cart.commit(session);
            response.sendRedirect("/LTWeb_war_exploded/Index");
        }
    }
}
