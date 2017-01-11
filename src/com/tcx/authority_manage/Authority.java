package com.tcx.authority_manage;

/**
 * Created by Tang on 2017/1/9.
 */
public class Authority {
    private String displayName;
    private String url;

    public Authority() {
    }

    public Authority(String displayName, String url) {
        this.displayName = displayName;
        this.url = url;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 重写equals()方法并且只是指定url，为了使用list的contain方法，
     * 如果一个Authority实例的url值为authorityList中一些实例的url值则放回true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        return url != null ? url.equals(authority.url) : authority.url == null;

    }

}
