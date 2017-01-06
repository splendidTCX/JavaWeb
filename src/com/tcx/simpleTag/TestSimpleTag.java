package com.tcx.simpleTag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/6.
 */
public class TestSimpleTag extends SimpleTagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String upperCaseValue = value.toUpperCase();
        getJspContext().getOut().println(upperCaseValue);

    }
}

/**
 * 如果我们只是单单实现SimpleTag接口就可以发现，除了处理标签执行的doTag方法，还有：
 * <p>
 * 1.如果是是有标签体，可以通过getParent()方法得到父标签，从而进行一系列的操作。
 * <p>
 * 2.JspContext类是PageContext类的父类，所以有和PageContext有一些同样的方法，可以利用setAttribute方法将数据放在PageContext EL隐含
 * 变量中。
 * <p>
 * 3.getJspBody()方法得到的JspFragment类实例有两个方法，其中invoke()方法较为重要，
 * JspFragment.invoke(Witer): Writer 即为标签体内容输出的字符流, 若为 null, 则输出到 getJspContext().getOut(), 即输出到页面上.
 */
class SimpleTag implements javax.servlet.jsp.tagext.SimpleTag {

    @Override
    public void doTag() throws JspException, IOException {

    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {

    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
