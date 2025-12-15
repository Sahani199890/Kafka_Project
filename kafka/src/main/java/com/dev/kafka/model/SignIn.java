package com.dev.kafka.model;

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

    public String getAuthSignIn() {
        return authSignIn;
    }

    public void setAuthSignIn(String authSignIn) {
        this.authSignIn = authSignIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
