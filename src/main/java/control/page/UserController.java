package control.page;

import entity.ProductEntity;
import entity.UserEntity;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UserController"  , urlPatterns = "/user")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id =  request.getParameter("id");
        UserEntity ue = new UserEntity();
        User u = ue.getUserByID(id);

        request.setAttribute("userDetail", u);
        request.getRequestDispatcher("User.jsp").forward(request,response);

    }
}
