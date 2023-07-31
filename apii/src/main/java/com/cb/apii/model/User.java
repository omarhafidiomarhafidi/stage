package com.cb.apii.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @JsonFormat(pattern = "yyyy/mm/dd")
    @Column(nullable = false)
    private String date_exp ;
    @Column(nullable = false)
    private String cin ;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String identite;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )

    private List<Role> roles = new ArrayList<>();


    public User(String name, String email, String password, String date_exp, String cin, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date_exp = date_exp;
        this.cin = cin;

        this.roles = roles;
    }

    public User(String name, String email, String password, String date_exp, String cin, String identite, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date_exp = date_exp;
        this.cin = cin;
        this.identite = identite;
        this.roles = roles;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }



}
