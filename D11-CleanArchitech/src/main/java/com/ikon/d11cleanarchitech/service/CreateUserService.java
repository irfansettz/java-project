package com.ikon.d11cleanarchitech.service;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.CreateUserUseCase;
import com.ikon.d11cleanarchitech.service.out.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return createUserPort.createUser(userEntity);
    }
}
