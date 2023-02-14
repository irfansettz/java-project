package com.ikon.d11cleanarchitech.service.out;

import com.ikon.d11cleanarchitech.entity.UserEntity;

public interface UpdateUserPort {
    UserEntity updateUserById(UserEntity userEntity, long id);
}
