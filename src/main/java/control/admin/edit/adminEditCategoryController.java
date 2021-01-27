package control.admin.edit;

import entity.BrandEntity;
import entity.CategoryEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminEditCategoryController" ,urlPatterns = "/adminEditCategory")
public class adminEditCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String cid = request.getParameter("id");
        String cname = request.getParameter("name");


        CategoryEntity ce = new CategoryEntity();
        ce.editCategory(cid,cname);
        response.sendRedirect("loadCategory");
    }
}
