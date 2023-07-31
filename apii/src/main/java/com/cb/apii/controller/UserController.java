package com.cb.apii.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "User Controller", description = "Endpoints for managing users")
@RequestMapping("/user")
public class UserController {
    @Operation(summary = "Display user info ")
    @GetMapping("/")
    public String registrationForm() {
        return "user";
    }
}
