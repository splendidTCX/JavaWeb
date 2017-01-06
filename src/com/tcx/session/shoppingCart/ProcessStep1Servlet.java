package com.tcx.session.shoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/6.
 */

public class ProcessStep1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取选中图书的信息，并将信息放入到session中
        String[] books = request.getParameterValues("book");

        request.getSession().setAttribute("books", books);
        //2.重定向页面到step-2.jsp页面
        response.sendRedirect(request.getContextPath() + "/session/shoppingcart/step-2.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
