package com.example.springbasics.user_controller.interfaces;

import com.example.springbasics.user_controller.dto.userDTO;

public interface IUserService {
    userDTO createUser(userDTO userDetails);
}
