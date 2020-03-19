package com.example.project.controller;

import com.example.project.entity.Periodicals;
import com.example.project.entity.Subscriptions;
import com.example.project.entity.Users;
import com.example.project.services.PeriodicalsServiceImpl;
//import com.example.project.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeriodicalsServiceController {

    private final PeriodicalsServiceImpl periodicalsService;

    @Autowired
    public PeriodicalsServiceController(PeriodicalsServiceImpl periodicalsService) {
        this.periodicalsService = periodicalsService;
    }

    @GetMapping(value = "/getAllPeriodicals")
    public ResponseEntity<?> getPeriodicals() {
        return ResponseEntity.ok(periodicalsService.getPeriodicals());
    }

    @GetMapping(value = "/getSubscriptionsById")
    public ResponseEntity<Subscriptions> getSubscriptions(@RequestParam(name = "id", required = true) Integer id) {
//        periodicalsService.getSubscriptions(id);
        return new ResponseEntity(periodicalsService.getSubscriptions(id), HttpStatus.OK);
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<Object> setUser(@RequestBody Users users) {
        periodicalsService.setUser(users);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @PostMapping(value = "/addPeriodicals")
    public ResponseEntity<Object> addPeriodicals(@RequestBody Periodicals periodicals) {
        periodicalsService.addPeriodicals(periodicals);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @PostMapping(value = "/addSubscriptions")
    public ResponseEntity<Object> setSubscriptions(@RequestParam Integer user_id, Integer periodicals_id, @RequestBody Subscriptions subscriptions) {
        periodicalsService.setSubcriptions(user_id, periodicals_id, subscriptions);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @PostMapping(value = "/updatePeriodicals")
    public ResponseEntity<Object> updateMonthlyFee(@RequestParam(value = "id", required = true) Integer id, Periodicals periodicals) {
        periodicalsService.updateMonthlyFee(id, periodicals);
        return new ResponseEntity<>("Update", HttpStatus.OK);
    }

    @PostMapping(value = "/getPeriodicalById")
    public ResponseEntity<?> getPeriodicalsById(@RequestParam(value = "id", required = true) Integer id) {
        return new ResponseEntity(periodicalsService.getPeriodicalsById(id), HttpStatus.OK);
    }


}
