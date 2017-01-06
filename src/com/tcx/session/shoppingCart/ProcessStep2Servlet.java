package com.tcx.session.shoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tang on 2017/1/6.
 */
public class ProcessStep2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数：name,address,cardType,card
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String cardType = request.getParameter("cardType");
        String card = request.getParameter("card");

        Customer customer = new Customer(name, address, cardType, card);
        //2.把请求信息存入到HttpSession中
        request.getSession().setAttribute("customer", customer);

        //3.重定向页面到confirm.jsp
        response.sendRedirect(request.getContextPath() + "/session/shoppingcart/confirm.jsp");

    }
}
