package com.dev.kafka.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SignIn {
    private String email;
    private String password;
    private String authSignIn;
    private String token;
    private String provider;

    public SignIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SignIn(String authSignIn, String provider, String token) {
        this.authSignIn = authSignIn;
        this.provider = provider;
        this.token = token;
    }
}
