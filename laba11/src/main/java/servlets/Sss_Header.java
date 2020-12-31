package servlets;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoSssHeader")
public class Sss_Header extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Thread.currentThread().sleep(10000);
        Integer x = request.getIntHeader("Value-x");
        Integer y = request.getIntHeader("Value-y");
        Integer z = x + y;
        response.setHeader("Value-z",z.toString());
    }
}
