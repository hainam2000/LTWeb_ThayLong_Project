package control;

import entity.BrandEntity;
import entity.CategoryEntity;
import entity.ProductEntity;
import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddProduct",urlPatterns = "/addProduct")
public class adminAddProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("new_pro_name");
        String new_pro_description = request.getParameter("new_pro_description");
        String new_pro_detail = request.getParameter("new_pro_detail");
        String new_pro_price = request.getParameter("new_pro_price");
        String new_pro_isSale = request.getParameter("new_pro_isSale");
        String new_pro_salePrice = request.getParameter("new_pro_salePrice");
        String new_pro_brandName = request.getParameter("new_pro_brandName");
        String new_pro_categoryName = request.getParameter("new_pro_categoryName");
        String new_pro_storage = request.getParameter("new_pro_storage");


        ProductEntity pe = new ProductEntity();
        BrandEntity be = new BrandEntity();
        CategoryEntity ce = new CategoryEntity();

        int id_brand = be.getIdByName(new_pro_brandName);
        int id_cate = ce.getIdByName(new_pro_categoryName);

        int id = pe.getMaxId()+1;

        pe.addProduct(id,name,new_pro_description,new_pro_detail,new_pro_price,new_pro_isSale,new_pro_salePrice,id_brand,id_cate,new_pro_storage);

        response.sendRedirect("loadProduct");


    }
}
