package com.tcx.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/8.
 */
public class LoginFilter extends HttpFilter {

    private String userSessionKey;
    private String redirectPath;
    private String[] uncheckUrls;


    @Override
    protected void init() {
        ServletContext servletContext = getFilterConfig().getServletContext();
        userSessionKey = servletContext.getInitParameter("userSessionKey");
        redirectPath = servletContext.getInitParameter("redirectPage");
        uncheckUrls = getFilterConfig().getInitParameter("uncheckUrls").split(",");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1.获取请求的URL
        String requestPath = request.getServletPath();
        //2.检查1获取的ServletPath为你不需要检查的路径中的一个，若是，则直接放行，方法结束
        for (String url : uncheckUrls) {
            if (url.equals(requestPath)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        //3.从session中获取sessionKey对应的值
        String userSessionValue = (String) request.getSession().getAttribute(userSessionKey);


        //4.若存在，则放行,若值不存在则重定向到web.xml中配置的重定向路径
        if (userSessionValue != null) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + redirectPath);
        }

    }
}
