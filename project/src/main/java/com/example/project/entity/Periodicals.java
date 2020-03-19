package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.Year;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "periodicals", schema = "project")
@Data
@NoArgsConstructor
public class Periodicals {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String title;
    private Integer releaseDate;
    private String edition;
    private Integer monthlyFee;
    @OneToMany(mappedBy = "periodicals")
    @JsonIgnore
    private List<Subscriptions> subscriptionsListPeriod;

    public Periodicals(String title, Integer release_date, String edition, Integer cost) {
        this.title = title;
        this.releaseDate = release_date;
        this.edition = edition;
        this.monthlyFee = cost;
    }


    @Override
    public String toString() {
        return String.format(
                "Periodicals[id=%d, title='%s']",
                id, title);
    }

}
