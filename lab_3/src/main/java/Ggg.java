import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GoGgg")
public class Ggg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get request in Ggg");
        if (request.getParameter("param").equals("task4")){
//            ServletContext servletContext = getServletContext();
//            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/task3.html");
//            requestDispatcher.forward(request, response);
            response.sendRedirect(request.getContextPath()+"/task3.html");
        }
        else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<h2>Param: " + request.getParameter("param") + " Ggg</h2>");
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post request in Ggg");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Firstname: "+request.getParameter("param")+"</h2>");
        writer.close();
    }
}
