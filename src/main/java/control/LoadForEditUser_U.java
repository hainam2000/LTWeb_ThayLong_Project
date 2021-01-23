package control;

import entity.UserEntity;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoadForEditUser_U",urlPatterns = "/LoadForEditUser_U")
public class LoadForEditUser_U extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uid = request.getParameter("uid");
        UserEntity ue = new UserEntity();
        User user = ue.getUserByID(uid);

        request.setAttribute("userDetail", user);

        request.getRequestDispatcher("EditUser_U.jsp").forward(request,response);
    }
}
