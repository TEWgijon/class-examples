package com.tew.gestioneitor.service.impl;

import com.tew.gestioneitor.model.User;
import com.tew.gestioneitor.service.LoginService;

public class SimpleLoginService implements LoginService {
    public User verify(String login, String password) {
        if (!validLogin(login, password)) return null;
        return new User(login, "Sr Ant�nez");
    }

    private boolean validLogin(String login, String password) {
        return "admin".equals(login) && "password".equals(password);
    }


}
