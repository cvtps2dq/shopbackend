package com.example.shopbackend.DTO;

import java.util.Date;

public class UserEntityDTO {
    private String email;
    private String password;
    private String nickname;
    private Date regDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public UserEntityDTO() {
    }

    public UserEntityDTO(String email, String password, String nickname, Date regDate) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.regDate = regDate;
    }
}
