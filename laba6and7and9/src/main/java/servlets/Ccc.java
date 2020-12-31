package servlets;

import models.CBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GoCcc")
public class Ccc extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        if (request.getMethod().equals("GET") || request.getMethod().equals("POST")) {
            if (request.getParameter("CBean").equals("new")) {
                String Value1 = request.getParameter("Value1");
                String Value2 = request.getParameter("Value2");
                String Value3 = request.getParameter("Value3");
                CBean cBean = new CBean(Value1, Value2, Value3);
//               request.setAttribute("atrCBean",cBean);
                session.setAttribute("atrCBean", cBean);
//                servletContext.setAttribute("atrCBean", cBean);
            } else {
                //CBean cBean = (CBean) servletContext.getAttribute("atrCBean"); //атрибут доступен пока работает приложение
//                CBean cBean = (CBean) request.getAttribute("atrCBean");        //аттрибут доступен в рамках одного запроса
                CBean cBean = (CBean) session.getAttribute("atrCBean");       //атрибут доступен в рамках текущей сессии
                if (!request.getParameter("Value1").equals(""))
                    cBean.setValue1(request.getParameter("Value1"));
                if (!request.getParameter("Value2").equals(""))
                    cBean.setValue2(request.getParameter("Value2"));
                if (!request.getParameter("Value3").equals(""))
                    cBean.setValue3(request.getParameter("Value3"));
//                request.setAttribute("atrCBean",cBean);
                session.setAttribute("atrCBean", cBean);
                //servletContext.setAttribute("atrCBean",cBean);
            }
            session.setAttribute("customAtr", "atr");
            session.removeAttribute("customAtr");
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/Ccc.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "Send get or post request");
        }
    }
}
