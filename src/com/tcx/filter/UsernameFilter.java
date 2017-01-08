package com.tcx.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/7.
 */
public class UsernameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("doUserNameFilter init!");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doUsernameFilter!");
        String username = servletRequest.getParameter("username");

        System.out.println(servletRequest);

        if (username != null && username.equals("Tom")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("message","用户名不正确！");

            servletRequest.getRequestDispatcher("/filter/login.jsp").forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("doUsernameFilter destroy!");
    }
}
