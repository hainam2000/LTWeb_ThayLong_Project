package control;

import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserController" ,urlPatterns = "/edit")
public class EditUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id, String fullName, String email, String phone, String address, String accountName, String password
        String uid = request.getParameter("id");
        String uname = request.getParameter("fullname");
        String uemail = request.getParameter("email");
        String uphone = request.getParameter("phone");
        String uaddress = request.getParameter("address");
        String username = request.getParameter("accountName");
        String newpass = request.getParameter("newpass");
        UserEntity ue = new UserEntity();
        ue.editUser(uid,uname,uemail,uphone,uaddress,username,newpass);
        response.sendRedirect("editUser");
    }
}
