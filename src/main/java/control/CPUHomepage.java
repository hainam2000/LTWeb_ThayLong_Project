package control;

import model.Product;
import model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "ProductHomepage", urlPatterns = "/CPU")
public class CPUHomepage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductEntity pe = new ProductEntity();
        Collection<Product> values = pe.getAllProductWithCategory("Product", "3");
//        Collection<Product> values = Data.dataCPU.values();
        request.setAttribute("list", values);
        request.getRequestDispatcher("CPU.jsp").forward(request,response);
    }
}
