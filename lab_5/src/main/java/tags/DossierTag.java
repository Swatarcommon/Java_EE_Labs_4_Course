package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DossierTag extends TagSupport {
    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<form method=\"post\">");
        return EVAL_BODY_INCLUDE;
    }

    @SneakyThrows
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("</form>");
        return  EVAL_PAGE;
    }
}
