package com.tcx.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/6.
 */
public class OtherWiseTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag chooseTag = (ChooseTag) getParent();
        boolean flag = chooseTag.isFlag();

        if (flag) {
            getJspBody().invoke(null);
        }

    }
}
