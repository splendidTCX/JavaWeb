package com.tcx.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/7.
 */
public class PasswordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("doPasswordFilter init!");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doPasswordFilter!");

        String password = servletRequest.getParameter("password");
        System.out.println(servletRequest);

        if (password != null && password.equals("1234")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("message","密码不正确！");
            servletRequest.getRequestDispatcher("/filter/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("doPasswordFilter destroy!");
    }
}
