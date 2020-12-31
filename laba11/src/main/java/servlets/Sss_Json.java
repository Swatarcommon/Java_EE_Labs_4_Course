package servlets;

import lombok.SneakyThrows;
import random.MyRand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoSssJson")
public class Sss_Json extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Thread.currentThread().sleep(1000);
        int n = request.getIntHeader("XRand-N");
        int number = new MyRand().get(5,10, true, true);
        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        String jsonString ="{\"Numbers\":[" ;
        for (int i = 0; i < number; i++)
            jsonString += ("{\"rand\":"+ new MyRand().get(-n,n,false,false).toString()+"}"+ ((i < number-1)?",":" "));
        jsonString+="]}";
        pw.println(jsonString);
    }
}
