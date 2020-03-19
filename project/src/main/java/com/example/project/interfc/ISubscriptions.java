package com.example.project.interfc;

import com.example.project.entity.Subscriptions;
import com.example.project.entity.Users;

import java.util.List;
import java.util.Optional;

public interface ISubscriptions {

    List<Subscriptions> findByPeriod(int period);

    void save(Subscriptions subscriptions);

    List<Subscriptions> findByUsers(Users users);

    Optional<Subscriptions> findById(Integer id);
}
