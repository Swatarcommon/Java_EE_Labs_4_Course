import lombok.SneakyThrows;

import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/GoReader")
public class ReadEmail extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = Session.getDefaultInstance(new Properties());
        Store store = session.getStore("imaps");
        store.connect(getServletContext().getInitParameter("HostIMAP"),
                Integer.parseInt(getServletContext().getInitParameter("PortIMAP")),
                getServletContext().getInitParameter("Username"),
                getServletContext().getInitParameter("Password"));
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Messages count: "+messages.length);
        printWriter.println("<table border=\"1\">");
        for ( Message message : messages ) {
            printWriter.println("<tr>");
            printWriter.println("<td>SendDate: "+message.getSentDate()+ "</td>");
            printWriter.println("<td>Subject: "+message.getSubject()+ "</td>");
            printWriter.println("<td>Content: "+message.getContent()+ "</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.flush();
    }
}
