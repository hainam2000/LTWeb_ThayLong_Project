package control.admin.search;

import entity.UserEntity;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "SearchUserController", urlPatterns = "/searchUser")
public class SearchUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchText");
        UserEntity ue = new UserEntity();
        Collection<User> userList = ue.searchUser(searchText);

        if(searchText != null) {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("UserManager.jsp").forward(request,response);
        } else response.sendRedirect("404.jsp");

    }
}
