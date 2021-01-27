package control.page;

import entity.CategoryEntity;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryManagerController"  , urlPatterns = "/loadCategory")
public class CategoryManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CategoryEntity ce = new CategoryEntity();
        List<Category> categoryList = ce.getAllCategory();

        request.setAttribute("categoryList", categoryList);

        request.getRequestDispatcher("CategoryManager.jsp").forward(request,response);
    }
}
