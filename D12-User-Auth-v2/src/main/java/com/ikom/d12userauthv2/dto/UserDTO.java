package com.ikom.d12userauthv2.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserDTO {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String name;
    private String role;
}