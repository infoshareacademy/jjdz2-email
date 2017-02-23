package com.jbd.database;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;

@SessionScoped
@Entity
@Table(name = "User")
public class sessionUser implements Serializable {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(sessionUser.class);
    private static final Marker MARKER = MarkerFactory.getMarker("SessionData");
    public static final int ADMIN = 1;
    public static final int LOCAL_USER = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isLogged = false;
    private String username;
    private String usermail;
    private int privilege;
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime loginTime;
    private String code = null;
    private Locale locale;


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

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }


    @Override
    public String toString() {
        return "SessionData{" +
                "id=" + id +
                ", isLogged=" + isLogged +
                ", username='" + username + '\'' +
                ", usermail='" + usermail + '\'' +
                ", privilege='" + privilege + '\'' +
                ", loginTime=" + loginTime +
                ", code='" + code + '\'' +
                '}';
    }
}
