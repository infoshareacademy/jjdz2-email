package com.jbd.Authorization;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;


@SessionScoped
public class SessionData implements Serializable {

    private boolean isLogged = false;
    private String username;
    private String password;
    private LocalDate loginTime;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public void login(String username, String password) {
        if ("admin".equals(username)&& "admin".equals(password)){
            System.out.println("Succesfull!");
            System.out.println("User " + username + "have logged in");
            this.isLogged = true;
            this.username = username;
            this.loginTime = LocalDate.now();

        }else {
            System.out.println("Login Failed");
        }
    }

}
