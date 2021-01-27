package control.page;

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

@WebServlet(name = "ProductManagerController", urlPatterns = "/loadProduct")
public class ProductManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageLimit = 25;
        String i = request.getParameter("index");
        if(i == null) {
            i = "1";
        }

        int indexPage = Integer.parseInt(i);
        ProductEntity pe = new ProductEntity();
        Collection<Product> productList = pe.getProductForPagging(20, indexPage);

        request.setAttribute("pageLimit", pageLimit);
        request.setAttribute("productsList", productList);
        request.getRequestDispatcher("ProductManager.jsp").forward(request,response);
        }
    }


