package control.page;

import entity.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "ProductController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("pid");

        ProductEntity pe = new ProductEntity();
        ImageEntity ie = new ImageEntity();

        Collection<Image> images = ie.getAllImageWithProductID(id);
        Collection<Product> products = pe.getRandomProduct("5");
        Product p = pe.getProductWithID(id);


        request.setAttribute("itemsList", products);
        request.setAttribute("images", images);
        request.setAttribute("product", p);


        request.getRequestDispatcher("SingleProduct.jsp").forward(request,response);
    }
}
