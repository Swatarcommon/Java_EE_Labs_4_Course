package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/GoCcc")
public class F1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter F1 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter pw = servletResponse.getWriter();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Execute Filter F1");
        try {
            int param;
            if (request.getParameter("Value1").equals(""))
                param = Integer.parseInt(request.getParameter("Value1"));
            if (request.getParameter("Value2").equals(""))
                param = Integer.parseInt(request.getParameter("Value2"));
            if (request.getParameter("Value3").equals(""))
                param = Integer.parseInt(request.getParameter("Value3"));
            filterChain.doFilter(servletRequest,servletResponse);
        }
        catch (Exception ex){
            pw.println("<h1>Filter F1 blocked request</h1>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Filter F1");
    }
}
