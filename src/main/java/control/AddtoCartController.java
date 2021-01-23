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
        String orderDetailID = request.getParameter("pid");
        String userID = request.getParameter("userID");
        OrderEntity orderEntity = new OrderEntity();
        HttpSession session = request.getSession();
        OrderDetail od = orderEntity.getOrderDetailByPID(orderDetailID);

        if(orderDetailID == null || od == null)  response.sendRedirect("/LTWeb_war_exploded/Index");
        else {
            Cart cart = Cart.getCartSession(session);
            cart.addOrderDetail(od);
            cart.commit(session);
            request.getRequestDispatcher("/Index").forward(request,response);
        }
    }
}
