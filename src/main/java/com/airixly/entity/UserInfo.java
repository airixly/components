package com.airixly.entity;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;

/**
 * User: Airixly
 * Date: 13-10-18
 */
public class UserInfo {
    private String id;
    private String username;
    private String password;
    private String type;
    private String privilege;
    private String description;

    public UserInfo() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
