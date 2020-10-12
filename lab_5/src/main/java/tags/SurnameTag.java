package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SurnameTag extends TagSupport {
    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<p>Surname: <input name=\"surname\" type=\"text\"/></p>");
        return SKIP_BODY;
    }
}
