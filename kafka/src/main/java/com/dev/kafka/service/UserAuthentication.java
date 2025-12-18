package com.dev.kafka.service;

import com.dev.kafka.config.security.JWTTokenGeneration;
import com.dev.kafka.entity.UsersEntity;
import com.dev.kafka.exception.BadRequestException;
import com.dev.kafka.model.UsersModel;
import com.dev.kafka.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthentication {

    private final UsersRepo usersRepo;
    private final JWTTokenGeneration tokenGeneration;

    public String signUpUser(UsersModel model){
        Optional<UsersEntity> usersOpt=usersRepo.findByEmail(model.getEmail());
        if(usersOpt.isEmpty()){
            UsersEntity usersEntity=new UsersEntity();
            BeanUtils.copyProperties(model,usersEntity);
            UsersEntity users=usersRepo.save(usersEntity);
            return tokenGeneration.generateToken(users.getUsername());
        }
        throw new BadRequestException("User already exists, please sign in");
    }
    public String signInUser(UsersModel model){
        Optional<UsersEntity> usersOpt=usersRepo.findByEmail(model.getEmail());
        if(usersOpt.isPresent()){
            if(model.getPassword().equals(usersOpt.get().getPassword())){
                return tokenGeneration.generateToken(model.getEmail()+"@@@"+model.getUserName());
            }
            throw new BadRequestException("Invalid password");
        }
        throw new BadRequestException("User not exists, please sign up");
    }

    public List<UsersModel> getAllUsers() {

        return usersRepo.findAll()
                .stream()
                .map(entity -> {
                    UsersModel model = new UsersModel();
                    BeanUtils.copyProperties(entity, model);
                    return model;
                })
                .toList();
    }
}
