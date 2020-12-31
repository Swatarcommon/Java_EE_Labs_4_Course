package servlets;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoAaa")
public class Aaa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        HttpClient hc = new HttpClient();
        PostMethod pm = new PostMethod("http://localhost:8081" + request.getContextPath() + "/GoBbb");

        pm.setParameter("first","1");
        pm.setParameter("second","2");
        pm.setParameter("third","3");

        pm.setRequestHeader("first","1");
        pm.setRequestHeader("second","2");
        pm.setRequestHeader("third","3");

        hc.executeMethod(pm);
        pw.println("<h2>Body:</h2>"+pm.getResponseBodyAsString());
        pw.println("<h2>Headers:</h2>");
        for (Header header : pm.getResponseHeaders()){
            pw.println(header+"<br>");
        }
        pw.flush();
    }
}
