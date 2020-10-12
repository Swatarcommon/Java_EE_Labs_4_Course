import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoSss")
public class Sss  extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getMethod();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (method.equals("GET")) {
            doGet(request, response);
        } else if (method.equals("POST")) {
            System.out.println("Post request in Sss");
//            ServletContext servletContext = getServletContext();
//            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/GoGgg");
//            requestDispatcher.forward(request, response);
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", request.getContextPath()+"/GoGgg");
        }else if (method.equals("PUT")){
            doPut(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Send get or post request");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get request in Sss");
        String path = "/GoGgg";
        String myPath = request.getContextPath() + "/GoGgg?param=My param";
        if (request.getParameter("param").equals("task3")) {
            myPath = request.getContextPath() + "/task3.html";
            path = "/task3.html";
        }
        else if (request.getParameter("param").equals("task4"))
            myPath = request.getContextPath() + "/GoGgg?param=task4";

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Param: " + request.getParameter("param") + " Sss</h2>");

          response.sendRedirect(myPath);
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
//        requestDispatcher.forward(request, response);
    }
}
