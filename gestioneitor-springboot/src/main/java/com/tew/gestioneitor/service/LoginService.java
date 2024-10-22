package com.tew.gestioneitor.service;

import com.tew.gestioneitor.model.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public User verify(String name, String password);
}
