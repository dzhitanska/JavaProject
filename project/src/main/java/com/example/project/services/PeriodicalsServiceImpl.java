package com.example.project.services;

import com.example.project.entity.Periodicals;
import com.example.project.entity.Subscriptions;
import com.example.project.entity.Users;
import com.example.project.interfc.IPeriodicals;
import com.example.project.interfc.ISubscriptions;
import com.example.project.interfc.IUsers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
public class PeriodicalsServiceImpl{

    private final IPeriodicals iPeriodicals;
    private final IUsers iUsers;
    private final ISubscriptions iSubscriptions;


    @Transactional(readOnly = true)
    public List<Periodicals> getPeriodicals(){
        return iPeriodicals.findAll();
    }

    @Transactional(readOnly = true)
    public List<Subscriptions> getSubscriptions(Integer id){
        Users users = iUsers.findById(id).orElseThrow();
        return iSubscriptions.findByUsers(users);
    }

    public void updateMonthlyFee(Integer id, Periodicals periodicals){
        Periodicals periodicals1 = iPeriodicals.findById(id).orElseThrow();
        if (periodicals.getEdition() != null) {
            periodicals1.setEdition(periodicals.getEdition());
        }
        if (periodicals.getMonthlyFee() != null) {
            periodicals1.setMonthlyFee(periodicals.getMonthlyFee());
        }
        if (periodicals.getReleaseDate() != null){
            periodicals1.setMonthlyFee(periodicals.getMonthlyFee());
        }
        if (periodicals.getTitle() != null){
            periodicals1.setTitle(periodicals.getTitle());
        }
    }

    public void setUser(Users user) {
        iUsers.save(user);
    }

    public void addPeriodicals(Periodicals periodicals) {
        iPeriodicals.save(periodicals);
    }

    public Optional<Periodicals> getPeriodicalsById(Integer id) {
        return iPeriodicals.findById(id);
    }

    public void setSubcriptions(Integer user_id, Integer periodicals_id, Subscriptions subscriptions) {
        Users users = iUsers.findById(user_id).orElseThrow();
        Periodicals periodicals = iPeriodicals.findById(periodicals_id).orElseThrow();

        subscriptions.setUsers(users);
        subscriptions.setPeriodicals(periodicals);
        iSubscriptions.save(subscriptions);
    }
}
