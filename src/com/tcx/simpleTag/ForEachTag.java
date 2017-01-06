package com.tcx.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * ForEach的实现思想是：
 * 1、得到属性item的值（集合），得到属性var的值（字符串）；
 * 2.遍历集合的值，并将值放入到PageContext域中，var属性值为KEY,集合每单个对象为VALUE
 */
public class ForEachTag extends SimpleTagSupport {

    private Collection<?> items;
    private String var;

    public Collection<?> getItems() {
        return items;
    }

    public void setItems(Collection<?> items) {
        this.items = items;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (items != null) {
            for (Object object : items) {
                getJspContext().setAttribute(var, object);
                getJspBody().invoke(null);
            }
        }
    }
}
