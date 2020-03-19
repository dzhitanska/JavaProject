package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "project")
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String phone;
    private String role;
    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<Subscriptions> subscriptionsListUsers;

    public Users(String name, String surname, String login, String phone, String role){
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
                "Users[id=%d, login='%s']",
                id, login);
    }

}
