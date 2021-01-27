package control.page;

import entity.CategoryEntity;
import entity.ProductEntity;
import entity.UserEntity;
import model.Category;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UserManagerController"  , urlPatterns = "/loadUser")
public class UserManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserEntity ue = new UserEntity();
        Collection<User> userList = ue.getAllUser();

        request.setAttribute("userList", userList);

        request.getRequestDispatcher("UserManager.jsp").forward(request,response);
    }
}
