import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/GoMmm")
public class Mmm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        String uri = "http://localhost:8080" + request.getContextPath() + "/GoGgg?param=name";
        GetMethod gm = new GetMethod(uri);
        hc.executeMethod(gm);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        String uri = "http://localhost:8080" + request.getContextPath() + "/GoGgg";
        PostMethod pm = new PostMethod(uri);
        pm.setParameter("param","Valentin");
        hc.executeMethod(pm);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println(pm.getResponseBodyAsString());
        pw.flush();
    }
}
