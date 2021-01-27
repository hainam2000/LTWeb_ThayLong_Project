package control.page;


import entity.ShippingEntity;

import model.Shipping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShippingManagerController"  , urlPatterns = "/loadShipping")
public class ShippingManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ShippingEntity se = new ShippingEntity();
        List<Shipping> shippingList = se.getAllShippingForManager();

        request.setAttribute("shippingList", shippingList);

        request.getRequestDispatcher("ShippingManager.jsp").forward(request,response);
    }
}
