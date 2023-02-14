package com.ikon.d11cleanarchitech.service;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.UpdateUserUseCase;
import com.ikon.d11cleanarchitech.service.out.UpdateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {
    final UpdateUserPort updateUserPort;

    @Override
    public UserEntity updateUserById(UserEntity userEntity, long id) {
        return updateUserPort.updateUserById(userEntity, id);
    }
}
