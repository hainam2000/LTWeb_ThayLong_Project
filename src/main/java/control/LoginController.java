package control;

import entity.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserEntity ue = new UserEntity();
        User u = ue.getUser(username, password);
        if(u == null) {
            request.setAttribute("mess", "Wrong username or password!");
            request.getRequestDispatcher("Index").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("Index");
        }
    }
}
