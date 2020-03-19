package com.example.project;


import com.example.project.entity.Periodicals;
import com.example.project.entity.Users;
import com.example.project.interfc.IPeriodicals;
import com.example.project.interfc.IUsers;
import com.example.project.repositories.PeriodicalsRepository;
import com.example.project.repositories.SubsciptionsRepository;
import com.example.project.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class ProjectApplication {

    @Autowired
    private IPeriodicals iPeriodicals;
    @Autowired
    private IUsers iUsers;

    private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class);
    }

    @Bean
    public CommandLineRunner demo(PeriodicalsRepository periodicalsRepository, UsersRepository usersRepository, SubsciptionsRepository subscriptions) {
        return (args) -> {



            // fetch all customers
            log.info("All periodicals:");
            log.info("-------------------------------");
            for (Periodicals periodicals : iPeriodicals.findAll()) {
                log.info(periodicals.toString());
            }
            log.info("");


            //fetch an individual customer by ID
            List<Periodicals> periodicals = iPeriodicals.findByEdition("Litres");
            log.info("Periodicals found with findByEdition(St.King):");
            log.info("--------------------------------");
            log.info(periodicals.toString());
            log.info("");

//            Optional<Users> users = usersRepository.findByLogin("dzhytanska");
            log.info("Users found with findByLogin(intohimo1105):");
            log.info("--------------------------------");
            for (Users users : iUsers.findByLogin("intohimo1105")) {
                log.info(users.toString());
            }
            log.info("");



        };
    }
}