package servlet;

import com.google.gson.Gson;
import dao.RefDao;
import entity.Reference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class References extends HttpServlet {
    private RefDao refDao;

    @Override
    public void init() {
        try {
            refDao = new RefDao(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           String sessionId = "";
           for (Cookie cookie : request.getCookies())
               if (cookie.getName().equals("JSESSIONID"))
                   sessionId = cookie.getValue();
           String json = new Gson().toJson(refDao.getReferences(request.getParameter("filter")));
           response.setContentType("application/json");
           response.setHeader("sessionId", sessionId);
           response.setCharacterEncoding("UTF-8");
           response.getWriter().write(json);
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Reference reference = new Gson().fromJson(json,Reference.class);
            refDao.addReference(reference);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Reference reference = new Gson().fromJson(json,Reference.class);
            refDao.updateReference(reference);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            refDao.deleteReference(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
