package control;

import entity.CategoryEntity;
import entity.ProductEntity;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "CategoryControl", urlPatterns = "/category")
public class CategoryControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductEntity pe = new ProductEntity();
        CategoryEntity ce = new CategoryEntity();
        String cateID = request.getParameter("cid");


        Collection<Product> products = pe.getAllProductByCategoryID(cateID);
        Collection<Category> categories = ce.getAllCategory();
        int pages = ce.getNumberPageWithCate(cateID);

        request.setAttribute("clist", categories);
        request.setAttribute("productsList", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
