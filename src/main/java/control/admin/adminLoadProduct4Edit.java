package control.admin;

import entity.ImageEntity;
import entity.ProductEntity;
import entity.UserEntity;
import model.Image;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "adminLoadProduct4Edit",urlPatterns = "/loadPro4Edit")
public class adminLoadProduct4Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        ProductEntity pe = new ProductEntity();
        ImageEntity ie = new ImageEntity();

        Product product = pe.getProductWithID(pid);
        Collection<Image> images = ie.getAllImageWithProductID(pid);


        request.setAttribute("images", images);
        request.setAttribute("productDetail", product);
        request.getRequestDispatcher("adminEditProduct.jsp").forward(request,response);



    }
}
