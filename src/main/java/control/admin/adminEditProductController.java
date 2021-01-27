package control;

import entity.ProductEntity;
import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminEditProductController" ,urlPatterns = "/adminEditProduct")
public class adminEditProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String details = request.getParameter("details");
        String price = request.getParameter("price");
        String isSale = request.getParameter("isSale");
        String salePrice = request.getParameter("salePrice");
        String brandName = request.getParameter("brandName");
        String categoryName = request.getParameter("categoryName");
        String storage = request.getParameter("storage");

        ProductEntity pe = new ProductEntity();
        pe.editProduct(id,name,description,details,price,isSale,salePrice,brandName,categoryName,storage);

        response.sendRedirect("loadProduct");
    }
}
