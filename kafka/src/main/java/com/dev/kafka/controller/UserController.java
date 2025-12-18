package com.dev.kafka.controller;

import com.dev.kafka.model.UsersModel;
import com.dev.kafka.service.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserAuthentication userAuthentication;

    @PostMapping("get-users-list")
    public ResponseEntity<List<UsersModel>> getAllUsers(){
        return ResponseEntity.of(Optional.ofNullable(userAuthentication.getAllUsers()));
    }


}
