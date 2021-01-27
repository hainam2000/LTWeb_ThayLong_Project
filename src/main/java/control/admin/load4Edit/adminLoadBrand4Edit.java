package control.admin.load4Edit;

import entity.BrandEntity;
import entity.UserEntity;
import model.Brand;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminLoadBrand4Edit",urlPatterns = "/loadBrand4Edit")
public class adminLoadBrand4Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String bid = request.getParameter("bid");
        BrandEntity be = new BrandEntity();
        Brand brand = be.getBrandByID(bid);
        request.setAttribute("brandDetail", brand);

        request.getRequestDispatcher("adminEditBrand.jsp").forward(request,response);
    }
}
