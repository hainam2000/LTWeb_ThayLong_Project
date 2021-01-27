package control;

import entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 @WebServlet(name = "userEditUserController" ,urlPatterns = "/editUser")
public class userEditUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("id");
        String uname = request.getParameter("fullname");
        String uemail = request.getParameter("email");
        String uphone = request.getParameter("phone");
        String uaddress = request.getParameter("address");
        String username = request.getParameter("username");
        String newpass = request.getParameter("newpass");

        UserEntity ue = new UserEntity();
        ue.editUser(uid,uname,uemail,uphone,uaddress,username,newpass);

        request.getRequestDispatcher("user").forward(request,response);
    }
}
