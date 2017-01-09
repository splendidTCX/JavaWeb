package com.tcx.authority_manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static Map<String, Object> usersMap = new HashMap<String, Object>();

    /**
     * 用户静态数据
     */
    static {
        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new Authority("article-1", "authority_manage/article-1.jsp"));
        authorities.add(new Authority("article-2", "authority_manage/article-2.jsp"));
        usersMap.put("AAA", new User("AAA", authorities));

        authorities = new ArrayList<Authority>();
        authorities.add(new Authority("article-3", "authority_manage/article-3.jsp"));
        authorities.add(new Authority("article-4", "authority_manage/article-4.jsp"));
    }




}
