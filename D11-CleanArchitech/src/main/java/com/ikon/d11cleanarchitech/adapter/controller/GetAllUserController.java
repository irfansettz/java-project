package com.ikon.d11cleanarchitech.adapter.controller;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GetAllUserController {
    private final GetAllUserUseCase getAllUserUseCase;

    @GetMapping
    public List<UserEntity>  getAllUser() {
        return getAllUserUseCase.getAllUser();
    }
}
