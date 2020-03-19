package com.example.project.interfc;

import com.example.project.entity.Periodicals;

import java.util.List;
import java.util.Optional;

public interface IPeriodicals {

    List<Periodicals> findByEdition(String edition);

    List<Periodicals> findAll();

    Optional<Periodicals> findById(Integer id);

    void save(Periodicals periodicals);
}
