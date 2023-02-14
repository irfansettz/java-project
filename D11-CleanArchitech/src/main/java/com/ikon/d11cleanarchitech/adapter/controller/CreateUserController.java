package com.ikon.d11cleanarchitech.adapter.controller;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return createUserUseCase.createUser(userEntity);
    }
}
