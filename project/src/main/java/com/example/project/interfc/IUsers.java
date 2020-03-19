package com.example.project.interfc;

import com.example.project.entity.Users;

import java.util.List;
import java.util.Optional;

public interface IUsers {
    List<Users> findByLogin(String login);

    void save(Users users);

    void deleteById(Integer id);

    List<Users> findAll();

    Optional<Users> findById(Integer id);
}
