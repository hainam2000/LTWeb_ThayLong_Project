package control.admin.add;


import entity.BrandEntity;
import entity.CategoryEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddCategory",urlPatterns = "/addCategory")
public class adminAddCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String cname = request.getParameter("new_category_name");


        CategoryEntity ce = new CategoryEntity();
        int id = ce.getMaxId()+1;

        ce.addCategory(id,cname);
        response.sendRedirect("loadCategory");


    }
}
