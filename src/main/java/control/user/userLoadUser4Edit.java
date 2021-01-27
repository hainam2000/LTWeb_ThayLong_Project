package control.user;

import entity.UserEntity;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userLoadUser4Edit",urlPatterns = "/load4Edit")
public class userLoadUser4Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        UserEntity ue = new UserEntity();
        if(id != null) {
            User user = ue.getUserByID(id);
            request.setAttribute("userDetail", user);
        }

        request.getRequestDispatcher("userEditUser.jsp").forward(request,response);
    }
}
