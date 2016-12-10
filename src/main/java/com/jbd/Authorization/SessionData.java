package com.jbd.Authorization;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;


@SessionScoped
public class SessionData implements Serializable {

    private boolean isLogged = false;
    private String username;
    private LocalDate loginTime;
    private String code = null;

    public boolean isLogged() {
        return isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public void login(String code,String username) {
        if(!code.equals("")){
            System.out.println("Succesfull");
            this.isLogged = true;
            this.username = username;
            this.code = code;
            //this.loginTime = loginTime;

        }
        else {
            System.out.println("Login Failed");
        }

    }

    public void logout(){
        this.isLogged = false;
        this.username = "";
        this.code = null;
    }

}
