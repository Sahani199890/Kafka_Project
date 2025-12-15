package com.dev.kafka.model;

public class SignUp {

    private String email;
    private String userName;
    private String password;
    private String confirmPassword;
    private String authSignUp;
    private String token;
    private String provider;

    public SignUp(String confirmPassword,String email, String password, String userName) {
        this.email=email;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public SignUp(String authSignUp, String token, String provider) {
        this.authSignUp = authSignUp;
        this.token = token;
        this.provider = provider;
    }

    public String getAuthSignUp() {
        return authSignUp;
    }

    public void setAuthSignUp(String authSignUp) {
        this.authSignUp = authSignUp;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
