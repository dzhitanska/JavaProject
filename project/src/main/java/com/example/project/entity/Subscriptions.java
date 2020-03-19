package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subscriptions", schema = "project")
@Data
@NoArgsConstructor
public class Subscriptions {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer period;
    private Integer cost;
    private String status;

    @ManyToOne
    @JoinColumn(name = "periodicals_id")
    private Periodicals periodicals;

    @ManyToOne
    @JoinColumn(name = "id_users")
    private Users users;


    public Subscriptions(Integer period, Integer cost, String status) {
        this.period = period;
        this.cost = cost;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Subscriptions[id=%d]",
                id);
    }
}
