package com.tcx.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by Tang on 2017/1/13.
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {

    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String content = super.getParameter(name);
        if (content.contains("fuck")) {
            content = content.replaceAll("fuck", "****");
        }
        return content;
    }
}
