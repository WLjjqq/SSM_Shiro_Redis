package com.shiro.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by 六
 * Date:18-7-21
 */
public class User implements Serializable {
    private Long id;
    private String nickname;
    private String email;
    private String pswd;
    private Date create_time;
    private Date last_login_time;
    private Long status;

    public User() {
    }

    public User(Long id, String nickname, String email, String pswd, Date create_time, Date last_login_time, Long status) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.pswd = pswd;
        this.create_time = create_time;
        this.last_login_time = last_login_time;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", pswd='" + pswd + '\'' +
                ", create_time=" + create_time +
                ", last_login_time=" + last_login_time +
                ", status=" + status +
                '}';
    }
}