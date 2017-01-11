package com.tcx.authority_manage;

import com.tcx.filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tang on 2017/1/10.
 */
public class AuthorityFilter extends HttpFilter {
    private String uncheckUrls;

    @Override
    protected void init() {
      uncheckUrls=   getFilterConfig().getInitParameter("nocheckUrls");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //得到拦截页面的url
        String url = request.getServletPath();
        //不需要进行拦截的路径直接放行
        List<String> uncheckUrlList= Arrays.asList(uncheckUrls.split(","));
        if (uncheckUrlList.contains(url)){
               filterChain.doFilter(request,response);
            return;
        }

        //从session中得到user信息,得到user拥有的权限信息
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {

            List<Authority> authorities = user.getAuthorities();

//            for (Authority authority : authorities) {
//                if (authority.getUrl().equals(url)) {
//                    filterChain.doFilter(request, response);
//                    return;
//                }
//            }

            //重写equals方法判断authorities中是否包含url
            if(authorities.contains(new Authority(null,url))){
                filterChain.doFilter(request, response);
                    return;
            }

        }
        response.sendRedirect(request.getContextPath() + "/authority_manage/noAu.jsp");


    }
}
