package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LastnameTag extends TagSupport {
    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<p>Lastname: <input name=\"lastname\" type=\"text\"/></p>");
        return SKIP_BODY;
    }
}
