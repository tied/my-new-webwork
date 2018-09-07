package com.talmer.plugin.logic;

public class ExchangeUserImpl implements ExchangeUser {
    private String login;

    private String password;


    public ExchangeUserImpl(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ExchangeUserImpl{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
