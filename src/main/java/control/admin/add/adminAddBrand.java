package control.admin.add;

import entity.BrandEntity;
import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddBrand",urlPatterns = "/addBrand")
public class adminAddBrand extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String bname = request.getParameter("new_brand_name");


        BrandEntity be = new BrandEntity();
        int id = be.getMaxId()+1;

        be.addBrand(id,bname);
        response.sendRedirect("loadBrand");


    }
}
