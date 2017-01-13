package com.tcx.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/13.
 */
public class ContentFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        MyHttpServletRequest myHttpServletRequest = new MyHttpServletRequest(request);
        filterChain.doFilter(myHttpServletRequest, response);
    }
}
