package control.admin.delete;

import entity.BrandEntity;
import entity.CategoryEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminDeleteCategoryController",urlPatterns = "/deleteCategory")
public class adminDeleteCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        CategoryEntity ce = new CategoryEntity();
        ce.deleteCategory(cid);
        response.sendRedirect("loadCategory");
       }
}
