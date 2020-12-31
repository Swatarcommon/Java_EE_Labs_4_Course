package servlets;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoUrln")
public class Urln extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = getServletContext().getInitParameter("urln");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        if (message != null){
            HttpClient hc = new HttpClient();
            String uri = "http://localhost:8081" + request.getContextPath() + "/" + message;
            GetMethod gm = new GetMethod(uri);
            hc.executeMethod(gm);
            pw.println(gm.getResponseBodyAsString());
            pw.flush();
        }
        else {
            pw.println("<h1>parameter URLn not found</h1>");
            pw.close();
        }
    }
}
