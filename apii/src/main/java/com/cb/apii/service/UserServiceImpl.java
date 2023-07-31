package com.cb.apii.service;


import com.cb.apii.dto.UserDto;
import com.cb.apii.model.Role;
import com.cb.apii.model.User;
import com.cb.apii.repository.RoleRepository;
import com.cb.apii.repository.UserRepository;
import com.cb.apii.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) throws IOException {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null) {
            role = roleRepository.save(new Role(TbConstants.Roles.USER));
        }

        // Validate file upload, e.g., check file size and allowed file types

        // Encode the password securely
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        // Perform file upload and handle exceptions if any
        try {
            String base64FileData = Base64.getEncoder().encodeToString(userDto.getFile().getBytes());

            // You can now use 'base64FileData' as needed (e.g., store it in the database)
            // ... other user details ...

            // Save the user to the database
            User user = new User(
                    userDto.getName(),
                    userDto.getEmail(),
                    encodedPassword,
                    userDto.getDate_exp(),
                    userDto.getCin(),
                    base64FileData,
                    Arrays.asList(role)
            );

            userRepository.save(user);
        } catch (IOException e) {
            // Handle the file upload exception
            throw new IOException("Failed to upload the file: " + e.getMessage());
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}