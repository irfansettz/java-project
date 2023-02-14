package com.ikon.d11cleanarchitech.service.in;

import com.ikon.d11cleanarchitech.entity.UserEntity;

public interface UpdateUserUseCase {
    UserEntity updateUserById(UserEntity userEntity, long id);
}
