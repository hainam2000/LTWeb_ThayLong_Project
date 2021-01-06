package control;

import entity.CategoryEntity;
import model.Category;
import model.Product;
import entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "Index", urlPatterns = "")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Collection<Product> values = Data.index.values();
//        request.setAttribute("index", values);
        ProductEntity pe = new ProductEntity();
        CategoryEntity ce = new CategoryEntity();

        Collection<Category> categories = ce.getAllCategory();
        Collection<Product> productList = pe.getRandomProduct("40");

        request.setAttribute("clist", categories);
        request.setAttribute("productsList", productList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }


