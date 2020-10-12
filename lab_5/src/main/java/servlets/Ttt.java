package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoTtt")
public class Ttt extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String surname = request.getParameter("surname");
        String lastname = request.getParameter("lastname");
        String sex = request.getParameter("sex");
        writer.println("Surname: "+surname);
        writer.println("Lastname: "+lastname);
        writer.println("Sex: "+sex);
        writer.close();
    }
}
