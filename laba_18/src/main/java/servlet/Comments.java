package servlet;

import com.google.gson.Gson;
import dao.CommentDao;
import entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet
public class Comments extends HttpServlet {
    private CommentDao commentDao;

    @Override
    public void init() {
        try {
            commentDao = new CommentDao(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = new Gson().toJson(commentDao.getComments(Integer.parseInt(request.getParameter("refId"))));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Comment comment = new Gson().fromJson(json,Comment.class);
            comment.setStamp(new Date(System.currentTimeMillis()));
            commentDao.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Comment comment = new Gson().fromJson(json,Comment.class);
            commentDao.updateComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            commentDao.deleteComment(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
