package com.example.project.repositories;

import java.util.List;
import java.util.Optional;


import com.example.project.entity.Users;
//import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    List<Users> findByLogin(String login);

}