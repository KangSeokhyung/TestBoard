package com.springboot.testboard.mapper;

import com.springboot.testboard.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDTO login(UserDTO userDTO);
    void register(UserDTO userDTO);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserDTO findByUsername(String username);
}
