package com.loginAuthentication.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="users")
@Entity(name="User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private Integer phone;
    private String bio;
    private String username;
    private String password;
    public User(DataCreateUser dataCreateUser){
        this.name = dataCreateUser.name();
        this.email = dataCreateUser.email();
        this.phone = dataCreateUser.phone();
        this.bio = dataCreateUser.bio();
        this.username = dataCreateUser.username();
        this.password = dataCreateUser.password();
    }
}
