package control.admin;

import entity.ImageEntity;
import entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminDeleteImageController",urlPatterns = "/deleteImage")
public class adminDeleteImageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imgId = request.getParameter("imgId");
        String pid = request.getParameter("pid");
        ImageEntity ie = new ImageEntity();

        ie.deleteImageWithIdAndPid(imgId,pid);
        response.sendRedirect("loadProduct");
       }
}
