import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/GoMail")
public class MailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sender = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        Properties properties = new Properties();
        properties.put("mail.smtp.host",getServletContext().getInitParameter("HostSMTP"));
        properties.put("mail.smtp.port",getServletContext().getInitParameter("PortSMTP"));
        properties.put("mail.from",sender);
        properties.put("mail.smtp.password",password);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","false" );

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender,password);
                    }
                });

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getParameter("receiver")));
            message.setSubject("Lab15");
            message.setText(request.getParameter("message"));
            Transport.send(message);
            pw.println("Message successfully send");
            pw.flush();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
