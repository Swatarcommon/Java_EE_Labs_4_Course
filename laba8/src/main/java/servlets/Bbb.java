package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoBbb")
public class Bbb extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("First param: "+request.getParameter("first")+"<br>");
        pw.println("Second param: "+request.getParameter("second")+"<br>");
        pw.println("Third param: "+request.getParameter("third")+"<br>");
        pw.println("First header: "+request.getHeader("first")+"<br>");
        pw.println("Second header: "+request.getHeader("second")+"<br>");
        pw.println("Third header: "+request.getHeader("third")+"<br>");

        response.setHeader("First_Header","1");
        response.setHeader("Second_Header","2");
        pw.flush();
    }
}
