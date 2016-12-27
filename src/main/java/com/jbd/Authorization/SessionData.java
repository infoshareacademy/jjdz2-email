package com.jbd.Authorization;

import com.jbd.Privilege;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


//@Converter(autoApply = true)
@SessionScoped
@Entity
@Table(name = "User")
public class SessionData implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(SessionData.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isLogged = false;
    private String username;
    private String usermail;
    private String privilege;
    //private Privilege privilege;
    private LocalDateTime loginTime;
    @Transient
    private String code = null;

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public void login(String code, String username, String usermail) {
        if(!code.equals("")){
            this.isLogged = true;
            this.username = username;
            this.usermail = usermail;
            this.code = code;
            this.loginTime = LocalDateTime.now();
            this.privilege = "local";
            LOGGER.info("Login successful");
        }
        else {
            LOGGER.error("Login Failed!");
        }

    }

    public void logout(){
        this.isLogged = false;
        this.username = "";
        this.usermail = "";
        this.code = null;
        LOGGER.info("Logout Successful");

    }

    @Override
    public String toString() {
        return "SessionData{" +
                "id='" + id + '\'' +
                ", isLogged=" + isLogged +
                ", username='" + username + '\'' +
                ", usermail='" + usermail + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
