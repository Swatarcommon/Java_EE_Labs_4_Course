import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/GoJjj")
public class Jjj extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equals("GET") || method.equals("POST")) {
            int hours = new Date().getHours();
            String name = "";
            if ( hours > 0 && hours < 6)
                name = "night.jsp";
            else if (hours > 6 && hours < 12)
                name = "morning.jsp";
            else if (hours > 12 && hours < 18)
                name = "afternoon.jsp";
            else if (hours > 18 && hours < 24)
                name = "evening.jsp";
            response.sendRedirect(name);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Send get or post request");
        }
    }
}
