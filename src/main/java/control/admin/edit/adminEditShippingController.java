package control.admin.edit;

import entity.BrandEntity;
import entity.ShippingEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminEditShippingController" ,urlPatterns = "/adminEditShipping")
public class adminEditShippingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String sid = request.getParameter("id");
        String sname = request.getParameter("name");
        String stype = request.getParameter("type");
        String spricce = request.getParameter("price");


        ShippingEntity se = new ShippingEntity();
        se.editShipping(sid,sname,stype,spricce);
        response.sendRedirect("loadShipping");
    }
}
