package control.admin.delete;


import entity.BrandEntity;
import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminDeleteBrandController",urlPatterns = "/deleteBrand")
public class adminDeleteBrandController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String bid = request.getParameter("bid");
        BrandEntity be = new BrandEntity();
        be.deleteBrand(bid);
        response.sendRedirect("loadBrand");
       }
}
