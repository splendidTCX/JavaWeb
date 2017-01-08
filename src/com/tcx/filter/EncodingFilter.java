package com.tcx.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/8.
 */
public class EncodingFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //设置的字符编码应该配置在web.xml中
        String encodingParam = getFilterConfig().getServletContext().getInitParameter("Encoding");
        request.setCharacterEncoding(encodingParam);
        filterChain.doFilter(request, response);
    }
}
