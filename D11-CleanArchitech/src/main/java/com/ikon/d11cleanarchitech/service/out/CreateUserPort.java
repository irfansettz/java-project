package com.ikon.d11cleanarchitech.service.out;

import com.ikon.d11cleanarchitech.entity.UserEntity;

public interface CreateUserPort {
    UserEntity createUser(UserEntity userEntity);
}
