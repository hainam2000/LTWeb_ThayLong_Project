package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "Servlet", urlPatterns = "/login")
public class Servlet extends HttpServlet {
    static HashMap<String,String> data = new HashMap<>();
    static {
        data.put("ti@gmail.com", "123123123");
        data.put("teo@gmail.com", "123123123");
        data.put("tass@gmail.com", "456456456");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.getWriter().println(username + " " + password);

        if(data.containsKey(username) && password.equals(data.get(username))){
            response.sendRedirect("index.html");
        } else {
            request.setAttribute("errMess", "Sai tai khoan hoac password");
            request.getRequestDispatcher("login.html").forward(request,response);
        }
    }
}

