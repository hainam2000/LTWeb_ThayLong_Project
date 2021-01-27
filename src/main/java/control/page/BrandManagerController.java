package control.page;

import entity.BrandEntity;
import entity.UserEntity;
import model.Brand;
import model.Category;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "BrandManagerController"  , urlPatterns = "/loadBrand")
public class BrandManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        BrandEntity be = new BrandEntity();
        List<Brand> brandList = be.getAllBrand();

        request.setAttribute("brandList", brandList);

        request.getRequestDispatcher("BrandManager.jsp").forward(request,response);
    }
}
