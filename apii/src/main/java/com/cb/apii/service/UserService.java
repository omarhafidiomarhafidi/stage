package com.cb.apii.service;

import com.cb.apii.dto.UserDto;
import com.cb.apii.model.User;

import java.io.IOException;

public interface UserService {
    void saveUser(UserDto userDto) throws IOException;

    User findUserByEmail(String email);
}
