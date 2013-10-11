package com.airixly.components.login;

/**
 * User: Airixly
 * Date: 13-10-11
 */
public class UserBean {
    private String username;
    private String password;
    private String id;

    public UserBean() {

    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
