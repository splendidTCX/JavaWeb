package com.tcx.authority_manage;

/**
 * Created by Tang on 2017/1/9.
 */
public class Authority {
    private String  displayName;
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
}
