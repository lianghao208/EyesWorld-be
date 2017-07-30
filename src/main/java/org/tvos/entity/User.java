package org.tvos.entity;

/**
 * Created by Administrator on 2017/7/26.
 */
public class User {

    private long id;
    private String username;
    private String password;
    private Boolean isUniqueUsername;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUniqueUsername() {
        return isUniqueUsername;
    }

    public void setUniqueUsername(Boolean uniqueUsername) {
        isUniqueUsername = uniqueUsername;
    }
}
