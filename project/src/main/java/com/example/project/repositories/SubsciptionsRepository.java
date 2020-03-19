package com.example.project.repositories;

import java.util.List;
import java.util.Optional;

import com.example.project.entity.Subscriptions;
import com.example.project.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface SubsciptionsRepository extends CrudRepository<Subscriptions, Integer> {

    List<Subscriptions> findByPeriod(int period);
    List<Subscriptions> findByUsers(Users users);

}
