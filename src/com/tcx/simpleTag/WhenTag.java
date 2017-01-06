package com.tcx.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;


public class WhenTag extends SimpleTagSupport {

    private Boolean test;

    public void setTest(Boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            ChooseTag chooseTag = (ChooseTag) getParent();
            boolean flag = chooseTag.isFlag();
            if (flag) {
                getJspBody().invoke(null);
                chooseTag.setFlag(false);
            }
        }
    }
}
