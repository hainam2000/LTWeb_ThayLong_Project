package control.admin.add;

import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddUser",urlPatterns = "/addUser")
public class adminAddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id_role = request.getParameter("new_user_role");
        String fullname = request.getParameter("new_user_fullname");
        String email = request.getParameter("new_user_email");
        String phone = request.getParameter("new_user_phone");
        String address = request.getParameter("new_user_address");
        String username = request.getParameter("new_username");
        String password = request.getParameter("new_user_password");

        UserEntity ue = new UserEntity();
        int id = ue.getMaxId()+1;

        ue.addUser(id,fullname,email,phone,address,id_role,username,password);
        response.sendRedirect("loadUser");


    }
}
