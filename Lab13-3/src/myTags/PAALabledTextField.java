package myTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class PAALabledTextField extends TagSupport {

    public String value = "";
    public String label = "";
    public String name = "";

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<label>" + label + "</label>"
                    + "<input name =\"" + name + "\" type = \"text\" width = \"150\""
                    + " maxlength= \"30\" value =\""+this.value+"\" />");
        } catch (IOException e) {
            System.out.println("EKALabledTextField: " + e);
        }
        return SKIP_BODY;
    }
    public class KirilTag extends TagSupport {
    }
}

