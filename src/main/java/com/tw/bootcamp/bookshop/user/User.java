package com.tw.bootcamp.bookshop.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;

    public User(CreateUserCommand userCommand) {
        email = userCommand.getEmail();
        password = userCommand.getPassword();
    }

    public UserView toView() {
        return UserView.builder()
                .id(id.toString())
                .email(email)
                .build();
    }

    public Long getId() {
        return id;
    }

}
