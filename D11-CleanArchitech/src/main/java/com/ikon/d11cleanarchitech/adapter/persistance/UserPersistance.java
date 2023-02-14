package com.ikon.d11cleanarchitech.adapter.persistance;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.out.CreateUserPort;
import com.ikon.d11cleanarchitech.service.out.GetAllUserPort;
import com.ikon.d11cleanarchitech.service.out.UpdateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPersistance implements CreateUserPort, GetAllUserPort, UpdateUserPort {
    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUserById(UserEntity userEntity, long id) {
        UserEntity user = userRepository.findById(id).get();
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return userRepository.save(user);
    }
}
