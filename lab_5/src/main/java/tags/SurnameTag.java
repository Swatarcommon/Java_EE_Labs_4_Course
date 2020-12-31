package tags;

import lombok.SneakyThrows;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SurnameTag extends TagSupport {
    public String java_SUCK;

    public String getJava_SUCK() {
        return java_SUCK;
    }

    public void setJava_SUCK(String java_SUCK) {
        this.java_SUCK = java_SUCK;
    }

    @SneakyThrows
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<p>Surname: <input name=\"surname\" type=\"text\"/></p>");
        return SKIP_BODY;
    }
}
