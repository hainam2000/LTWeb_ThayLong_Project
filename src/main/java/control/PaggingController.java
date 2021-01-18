package control;

import model.*;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "Servlet", urlPatterns = "/page")
public class PaggingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("index");
        int indexPage = Integer.parseInt(index);

        ProductEntity pe = new ProductEntity();
        Collection<Product> pages = pe.getProductForPagging(500, indexPage);
        request.setAttribute("Index", pages);
        request.getRequestDispatcher("Index").forward(request,response);
    }
}
