import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AS/GoSss")
public class Sss extends HttpServlet {
    List<String> lifeCycle = new ArrayList<String>();

    @Override
    public void init() throws ServletException {
        System.out.println("init");
        lifeCycle.add("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        lifeCycle.add("service");

        String method = request.getMethod();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Method: "+method+"</h2>");
        writer.println("<h2>Server Name: "+request.getServerName()+"</h2>");
        writer.println("<h2>Local address: "+request.getLocalAddr()+"</h2>");
        String consoleLog = "<h2>";
        for (String state: lifeCycle) {
            consoleLog = consoleLog + state + "<br>";
        }
        consoleLog = consoleLog + "</h2>";
        writer.println(consoleLog);

        if (method.equals("GET")) {
            doGet(request, response);
        } else if (method.equals("POST")) {
            doPost(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Send get or post request");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String firstname = request.getParameter("firstname");
        String secondname = request.getParameter("secondname");
        if (!firstname.equals(null) && !secondname.equals(null)){
            writer.println("<h2>"+firstname+" "+secondname+"</h2>");
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String firstname = request.getParameter("firstname");
        String secondname = request.getParameter("secondname");
        if (!firstname.equals(null) && !secondname.equals(null)){
            writer.println("<h2>"+firstname+" "+secondname+"</h2>");
        }
        writer.close();
    }
}
