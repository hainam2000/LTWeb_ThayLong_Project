package control;

import entity.ProductEntity;
import entity.UserEntity;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoadForEditUser_A",urlPatterns = "/LoadForEditProduct_A")
public class LoadForEditProduct_A extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        ProductEntity pe = new ProductEntity();
        Product product = pe.getProductWithID(pid);

        request.setAttribute("productDetail", product);

        request.getRequestDispatcher("EditProduct_A.jsp").forward(request,response);
    }
}
