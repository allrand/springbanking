package com.xkxx.springbanking.commands;

public class LoginCommand {
    private String userId;
    private String password;

    public LoginCommand() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
