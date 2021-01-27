package control.admin.delete;


import entity.BrandEntity;
import entity.ShippingEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminDeleteShippingController",urlPatterns = "/deleteShipping")
public class adminDeleteShippingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sid = request.getParameter("sid");
        ShippingEntity se =  new ShippingEntity();
        se.deleteShipping(sid);
        response.sendRedirect("loadShipping");
       }
}
