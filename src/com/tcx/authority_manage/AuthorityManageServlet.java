package com.tcx.authority_manage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class AuthorityManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private UserDao userDao = new UserDao();

    public void getAuthorities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        User user = userDao.getUser(username);
        request.setAttribute("user", user);
        request.setAttribute("authorities", userDao.getAuthorities());
        request.getRequestDispatcher("/authority_manage/authoritiesManage.jsp").forward(request, response);
    }


    public void updateAuthorities(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String[] authorityUrls = request.getParameterValues("url");
        List<Authority> userAuthorities = userDao.getAuthorities(authorityUrls);
        userDao.updateAuthority(username, userAuthorities);
        response.sendRedirect(request.getContextPath() + "/authority_manage/authoritiesManage.jsp");
    }
}
