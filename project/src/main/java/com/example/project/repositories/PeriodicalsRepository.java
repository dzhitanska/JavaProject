package com.example.project.repositories;

import java.util.List;
import java.util.Optional;

import com.example.project.entity.Periodicals;
import org.springframework.data.repository.CrudRepository;

public interface PeriodicalsRepository extends CrudRepository<Periodicals, Integer> {

    List<Periodicals> findByEdition(String edition);
//    List<Periodicals> findAll();


}
