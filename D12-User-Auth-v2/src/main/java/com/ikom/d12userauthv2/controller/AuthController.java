package com.ikom.d12userauthv2.controller;

import com.ikom.d12userauthv2.dto.ResponseDTO;
import com.ikom.d12userauthv2.dto.UserDTO;
import com.ikom.d12userauthv2.entity.User;
import com.ikom.d12userauthv2.service.TokenService;
import com.ikom.d12userauthv2.service.impl.JpaUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final JpaUserDetailService jpaUserDetailService;
    @PostMapping("/register")
    public String addUser(@RequestBody UserDTO userDTO) {
        tokenService.addUser(userDTO);
        return "success";
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> token(@RequestBody User user) {
        User userByPhone = tokenService.getUserByPhone(user);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userByPhone.getUsername(), user.getPassword()));
        System.out.println(authentication);
        String token = tokenService.generatedToken(authentication);
        return new ResponseEntity(ResponseDTO.builder().httpStatus(HttpStatus.OK).message("token created").data(token).build(), HttpStatus.OK);

    }
    @GetMapping("/info")
    public ResponseEntity<ResponseDTO<Object>> userInfo(@RequestHeader(name = "Authorization") String tokenBearer) {

        UserDTO user = tokenService.decodeToken(tokenBearer);

        return new ResponseEntity(ResponseDTO.builder().httpStatus(HttpStatus.OK).message("token found").data(user).build(), HttpStatus.OK);

    }
    //user
    @GetMapping("/user-data-2")
    public ResponseEntity<UserDTO> userInfo2(@RequestHeader(name = "Authorization") String tokenBearer) {
        UserDTO user = tokenService.decodeToken(tokenBearer);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/all-users")
    public ResponseEntity<List<UserDTO>> allUsers() {
        log.info("AuthController method allUsers");
        return new ResponseEntity<>(jpaUserDetailService.getAll(), HttpStatus.OK);
    }
}
