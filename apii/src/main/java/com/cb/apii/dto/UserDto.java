package com.cb.apii.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class    UserDto {
    private Long id;

    @NotEmpty(message="enter a valid name .")
    private String name;

    @NotEmpty(message = "Please enter valid email.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter valid password.")
    private String password;

    @NotEmpty(message = "Please enter valid CIN.")
    private String cin;

    @NotEmpty(message = "Please enter valid expiration date for Cin.")
    private String date_exp;


    private MultipartFile file;
}

