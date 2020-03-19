package com.example.project.spring_data;

import com.example.project.entity.Periodicals;
import com.example.project.interfc.IPeriodicals;
import com.example.project.repositories.PeriodicalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("PeriodicalsRepository")
@Transactional
@AllArgsConstructor

public class PeriodicalsImpl implements IPeriodicals {
    private final PeriodicalsRepository periodicalsRepository;


    @Override
    public List<Periodicals> findByEdition(String edition) {
        return (List<Periodicals>) periodicalsRepository.findByEdition(edition);
    }

    @Override
    public List<Periodicals> findAll() {
        return (List<Periodicals>) periodicalsRepository.findAll();
    }

    @Override
    public Optional<Periodicals> findById(Integer id) {
        return periodicalsRepository.findById(id);
    }

    @Override
    public void save(Periodicals periodicals) {
        periodicalsRepository.save(periodicals);
    }


}
