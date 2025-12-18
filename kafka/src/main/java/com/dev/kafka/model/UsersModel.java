package com.dev.kafka.model;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
public class UsersModel {

    private String email;
    private String userName;
    private String password;
    private String confirmPassword;
    private String authSignUp;
    private String token;
    private String provider;
}
