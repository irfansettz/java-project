package com.ikon.d11cleanarchitech.service;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import com.ikon.d11cleanarchitech.service.in.GetAllUserUseCase;
import com.ikon.d11cleanarchitech.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {
    private final GetAllUserPort getAllUserPort;

    @Override
    public List<UserEntity> getAllUser() {
        return getAllUserPort.getAllUser();
    }
}
