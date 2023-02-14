package com.ikon.d11cleanarchitech.adapter.controller;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UpdateUserController {
    final UpdateUserUseCase updateUserUseCase;

    @PutMapping("/{id}")
    public UserEntity updateUserById(@RequestBody UserEntity userEntity, @PathVariable long id){
        return updateUserUseCase.updateUserById(userEntity, id);
    }
}
