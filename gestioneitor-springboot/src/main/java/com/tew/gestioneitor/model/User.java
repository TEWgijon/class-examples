package com.tew.gestioneitor.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 11112L;
    private String login;
    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
