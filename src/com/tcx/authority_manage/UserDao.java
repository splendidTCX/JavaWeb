package com.tcx.authority_manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static Map<String, Object> usersMap = new HashMap<String, Object>();

    private static List<Authority> authorities = new ArrayList<Authority>();

    /**
     * 用户静态数据
     */
    static {
        authorities.add(new Authority("article-1", "/authority_manage/article-1.jsp"));
        authorities.add(new Authority("article-2", "/authority_manage/article-2.jsp"));
        authorities.add(new Authority("article-3", "/authority_manage/article-3.jsp"));
        authorities.add(new Authority("article-4", "/authority_manage/article-4.jsp"));
        usersMap.put("AAA", new User("AAA", authorities.subList(0, 2)));

        usersMap.put("BBB", new User("BBB", authorities.subList(2, 4)));

    }

    /**
     * 通过用户名得到用户
     */
    public User getUser(String username) {
        User user = (User) usersMap.get(username);
        return user;
    }

    /**
     * 修改用户的权限信息
     */
    public void updateAuthority(String username, List<Authority> authorities) {
        usersMap.put(username, new User(username, authorities));
    }


    /**
     * 当前所有被控制权限的页面
     */
    public List<Authority> getAuthorities() {
        return authorities;
    }

    /**
     * 通过将form提交的urls将其映射为一个List<Authority>列表
     */
    public List<Authority> getAuthorities(String[] urls) {
        List<Authority> authorities2 = new ArrayList<>();

        for (Authority authority : authorities) {
            if (urls != null) {
                for (String url : urls) {
                    if (url.equals(authority.getUrl())) {
                        authorities2.add(authority);
                    }
                }
            }
        }

        return authorities2;
    }
}
