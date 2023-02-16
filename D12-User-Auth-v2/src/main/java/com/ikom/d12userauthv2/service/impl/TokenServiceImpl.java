package com.ikom.d12userauthv2.service.impl;

import com.ikom.d12userauthv2.dto.UserDTO;
import com.ikom.d12userauthv2.entity.User;
import com.ikom.d12userauthv2.exception.InvalidPasswordException;
import com.ikom.d12userauthv2.exception.UserNotFoundException;
import com.ikom.d12userauthv2.respository.UserRepository;
import com.ikom.d12userauthv2.service.TokenService;
import com.ikom.d12userauthv2.util.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;

    @Override
    public User getUserByPhone(User user) {
        return userRepository.findByPhone(user.getPhone()).get();
    }

    @Override
    public String generatedToken(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @Override
    public UserDTO decodeToken(String token) {
        String newToken = token.split(" ")[1];
        Jwt jwtToken = jwtDecoder.decode(newToken);
        String data = jwtToken.getSubject();
        Optional<User> user = userRepository.findByUsername(data);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        }
        throw new UserNotFoundException("user not found");
    }

    @Override
    @Transactional()
    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        if (!PasswordValidator.isValid(user.getPassword())) {
            throw new InvalidPasswordException("error");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}

