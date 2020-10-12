package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SexTag extends TagSupport {
    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<p><input name=\"sex\" type=\"radio\" value=\"male\">Male</p>" +
                "<p><input name=\"sex\" type=\"radio\" value=\"female\">Female</p>");
        return SKIP_BODY;
    }
}
