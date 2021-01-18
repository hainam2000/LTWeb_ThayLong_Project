package control;

import entity.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterController", urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String mail = request.getParameter("mail");
        UserEntity ue = new UserEntity();
        User u = ue.checkExist(username, mail);
        if(!password.equals(confirmPassword)) {
            request.getRequestDispatcher("").forward(request,response);
            request.setAttribute("mess", "Confirm password is incorrect!");
        } else if(u != null) { //
            request.getRequestDispatcher("").forward(request,response);
            request.setAttribute("mess", "Username or email is duplicated!");
        } else if(u == null) {
            ue.register(username, password, mail);
            response.sendRedirect("Index");
        }
    }
}
