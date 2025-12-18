package com.dev.kafka.controller;

import com.dev.kafka.model.UsersModel;
import com.dev.kafka.service.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class SignUpController {

    private final UserAuthentication userAuthentication;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UsersModel model){
        return ResponseEntity.ok(userAuthentication.signUpUser(model));
    }
    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody UsersModel model){
        return ResponseEntity.ok(userAuthentication.signInUser(model));
    }
}
