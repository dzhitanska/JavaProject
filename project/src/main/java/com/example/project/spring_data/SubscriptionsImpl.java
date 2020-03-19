package com.example.project.spring_data;

import com.example.project.entity.Subscriptions;
import com.example.project.entity.Users;
import com.example.project.interfc.ISubscriptions;
import com.example.project.repositories.SubsciptionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("SubscriptionsRepository")
@Transactional
@AllArgsConstructor

public class SubscriptionsImpl implements ISubscriptions {
    private SubsciptionsRepository subsciptionsRepository;

    @Override
    public List<Subscriptions> findByPeriod(int period) {
        return (List<Subscriptions>) subsciptionsRepository.findByPeriod(period);
    }

    @Override
    public void save(Subscriptions subscriptions) {
        subsciptionsRepository.save(subscriptions);
    }

    @Override
    public List<Subscriptions> findByUsers(Users users) {
        return (List<Subscriptions>) subsciptionsRepository.findByUsers(users);
    }

    @Override
    public Optional<Subscriptions> findById(Integer id) {
        return subsciptionsRepository.findById(id);
    }
}
