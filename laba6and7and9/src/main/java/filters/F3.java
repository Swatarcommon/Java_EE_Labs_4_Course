package filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/GoCcc")
public class F3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter F3 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter pw = servletResponse.getWriter();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Execute Filter F3");
        boolean flag = false;
        if (servletRequest.getParameter("Value1").equals("1488"))
            flag = true;
        if (servletRequest.getParameter("Value2").equals("1488"))
            flag = true;
        if (servletRequest.getParameter("Value3").equals("1488"))
            flag = true;
        if (!flag)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            pw.println("<h1>Filter F3 blocked request. We are against violence ಠ_ಠ</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Filter F3 destroy");
    }
}
