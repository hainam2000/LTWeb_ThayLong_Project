package control.admin.search;

import entity.ProductEntity;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "AdminSearchController", urlPatterns = "/productSearch")
public class AdminSearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchText");
        ProductEntity pe = new ProductEntity();
        Collection<Product> products = pe.searchProduct(searchText);
        if(searchText != null) {
            request.setAttribute("productsList", products);
            request.getRequestDispatcher("ProductManager.jsp").forward(request,response);
        } else response.sendRedirect("404.jsp");

    }
}
