package com.springboot.testboard.service;

import com.springboot.testboard.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO login(UserDTO userDTO);
    void register(String email, String username, String password);
}
