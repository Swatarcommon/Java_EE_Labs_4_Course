package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SubmitTag extends TagSupport {
    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<p><input formaction=\"GoTtt\" type=\"submit\" value=\"Ok\">&nbsp;"+
                "<input formaction=\"index.jsp\" type=\"submit\" value=\"Cancel\"></p>");
        return SKIP_BODY;
    }
}
