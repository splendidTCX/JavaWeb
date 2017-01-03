package com.tcx.token;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/3.
 */

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模拟耗时操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String token = (String) request.getSession().getAttribute("token");
//
//        if (token == null) {
//            System.out.println("未在session中得到token信息");
//        }
//        if (token != null && token.equals(request.getParameter("token"))) {
//            //如果session中的token不为空且与隐藏域中的token相同则将session中的token删除, 并在if结束后受理请求;
//            request.getSession().removeAttribute("token");
//        } else {
//            request.getRequestDispatcher("/token/token.jsp").forward(request, response);
//            return;
//        }
        boolean isValid = TokenProcessor.getInstance().isTokenValid(request);
        if (isValid) {
            TokenProcessor.getInstance().resetToken(request);
        } else {
            request.getRequestDispatcher("/token/token.jsp").forward(request, response);
            return;
        }

        System.out.println(request.getParameter("username"));
        System.out.println("受理请求！");
        request.getRequestDispatcher("/token/success.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
