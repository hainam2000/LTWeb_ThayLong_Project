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

@WebServlet(name = "SearchController", urlPatterns = "/search")
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("search");
        CategoryEntity ce = new CategoryEntity();
        ProductEntity pe = new ProductEntity();
        Collection<Product> products = pe.searchProduct(txtSearch);
        Collection<Category> categories = ce.getAllCategory();
        request.setAttribute("clist", categories);
        request.setAttribute("productsList", products);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
