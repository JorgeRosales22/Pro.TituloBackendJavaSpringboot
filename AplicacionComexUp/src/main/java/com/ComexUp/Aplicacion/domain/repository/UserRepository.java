package com.ComexUp.Aplicacion.domain.repository;

import com.ComexUp.Aplicacion.domain.dto.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    User getUser(String email);
    String save(User user);
    boolean delete (String email);
}
