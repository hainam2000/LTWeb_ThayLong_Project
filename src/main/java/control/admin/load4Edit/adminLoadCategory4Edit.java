package control.admin.load4Edit;

import entity.CategoryEntity;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminLoadCategory4Edit",urlPatterns = "/loadCategory4Edit")
public class adminLoadCategory4Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cid = request.getParameter("cid");
        CategoryEntity ce = new CategoryEntity();
        Category category = ce.getCategoryByID(cid);

        request.setAttribute("categoryDetail", category);

        request.getRequestDispatcher("adminEditCategory.jsp").forward(request,response);
    }
}
