package com.xkxx.springbanking.entity;

public class LoginInfo {
    private String checkPassword;
    private String email;
    private String message;
    private String password;

    public LoginInfo() {
    }

    public String getCheckPassword() {
        return this.checkPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
