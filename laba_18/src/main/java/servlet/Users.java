package servlet;

import com.google.gson.Gson;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class Users extends HttpServlet {

    private static  boolean currentAdmin = false;
    private static  boolean isCurrentLogIn = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        isCurrentLogIn = true;
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json;
        if (isCurrentLogIn){
            json = new Gson().toJson("SignIn");
            isCurrentLogIn = false;
        }
        else {
            json = request.getReader().readLine();
            User user = new Gson().fromJson(json, User.class);
            if (!currentAdmin) {
                if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
                    json = new Gson().toJson("admin");
                    currentAdmin = true;
                } else if (user.getUsername().equals("client") && user.getPassword().equals("password"))
                    json = new Gson().toJson("client");
                else {
                    json = new Gson().toJson("error");
                }
            } else {
                if (user.getUsername().equals("reset") && user.getPassword().equals("reset")) {
                    json = new Gson().toJson("client");
                    currentAdmin = false;
                } else
                    json = new Gson().toJson("admin");
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
