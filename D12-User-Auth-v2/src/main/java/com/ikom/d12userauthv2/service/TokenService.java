package com.ikom.d12userauthv2.service;

import com.ikom.d12userauthv2.dto.UserDTO;
import com.ikom.d12userauthv2.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

public interface TokenService {
    User getUserByPhone(User user);

    String generatedToken(Authentication authentication);

    UserDTO decodeToken(String token);

    @Transactional()
    void addUser(UserDTO userDTO);
}
