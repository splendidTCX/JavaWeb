package com.tcx.authority_manage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Tang on 2017/1/10.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            //除了传递方法名，还传递方法调用时传递参数的类型
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 登录时调用的方法，将用户信息放入到session中,并将用户重定向到articleList页面
     */
    private UserDao userDao = new UserDao();

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");
        User user = userDao.getUser(username);
        request.getSession().setAttribute("user", user);
        //用户重定向到articleList页面
        response.sendRedirect(request.getContextPath() + "/authority_manage/articleList.jsp");
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/authority_manage/login.jsp");
        request.getRequestDispatcher("").forward(request,response);
    }
}
