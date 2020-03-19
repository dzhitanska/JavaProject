package com.example.project.spring_data;

import com.example.project.entity.Users;
import com.example.project.interfc.IUsers;
import com.example.project.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("UsersRepository")
@Transactional
@AllArgsConstructor

public class UsersImpl implements IUsers {
    private final UsersRepository usersRepository;


    @Override
    public List<Users> findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }
}
