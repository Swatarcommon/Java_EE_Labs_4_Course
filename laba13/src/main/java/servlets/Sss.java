package servlets;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/GoSss")
public class Sss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filesDir = getServletContext().getInitParameter("filesDir");
        Logger logger = Logger.getLogger("com.anexinet.sample");
        logger.info("Files Directory: " + filesDir);
        if (request.getParameter("file")!=null){
            logger.info(request.getParameter("file"));
            File file = new File(filesDir+"\\"+request.getParameter("file"));
            response.setContentType("application/msword");
            response.addHeader("Content-Disposition", "attachment; filename="+ file.getName());
            response.setContentLength((int) file.length());

            FileInputStream in = new FileInputStream(file);
            BufferedInputStream buf = new BufferedInputStream(in);
            ServletOutputStream out = response.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1)
                out.write(readBytes);
        }
    }
}
