package com.tcx.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * when choose otherwise实现的思想：
 * 1.choose 为when otherwise的父标签，choose标签中有一个boolean属性初始化为true，
 * 如果在choose中有符合条件的则将其设置为false。并将choose中的标签体输出到页面上。
 * 2.如果一直到最后都没有将boolean属性值设置为false,则将otherwise标签体中的内容输出到页面上。
 */
public class ChooseTag extends SimpleTagSupport {

    private Boolean flag = true;

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(null);
    }
}
