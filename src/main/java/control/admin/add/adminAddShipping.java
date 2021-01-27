package control.admin.add;

import entity.BrandEntity;
import entity.ShippingEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddShipping",urlPatterns = "/addShipping")
public class adminAddShipping extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String sname = request.getParameter("new_shipping_name");
        String stype = request.getParameter("new_shipping_type");
        String sprice = request.getParameter("new_shipping_price");


        ShippingEntity se = new ShippingEntity();
        int id = se.getMaxId()+1;

        se.addShipping(id,sname,stype,sprice);
        response.sendRedirect("loadShipping");


    }
}
