package control.admin.load4Edit;

import entity.BrandEntity;
import entity.ShippingEntity;
import model.Brand;
import model.Shipping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminLoadShipping4Edit",urlPatterns = "/loadShipping4Edit")
public class adminLoadShipping4Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sid = request.getParameter("sid");
        ShippingEntity se = new ShippingEntity();
        Shipping shipping= se.getShippingByID(sid);
        request.setAttribute("shippingDetail", shipping);

        request.getRequestDispatcher("adminEditShipping.jsp").forward(request,response);
    }
}
