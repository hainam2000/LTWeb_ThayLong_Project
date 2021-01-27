package control.page;

import entity.CategoryEntity;
import entity.ImageEntity;
import entity.PageEntity;
import model.Category;
import model.Image;
import model.Product;
import entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "Index", urlPatterns = "/Index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageLimit = 15;
        String i = request.getParameter("index");
        if(i == null) {
            i = "1";
        }

        int indexPage = Integer.parseInt(i);
        ProductEntity pe = new ProductEntity();
        CategoryEntity ce = new CategoryEntity();

        Collection<Product> productList = pe.getProductForPagging(20, indexPage);
//        Collection<Product> productList = pe.getRandomAll();
        Collection<Category> categories = ce.getAllCategory();
        request.setAttribute("pageLimit", pageLimit);
        request.setAttribute("clist", categories);
        request.setAttribute("productsList", productList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }


