package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.dto.LoginDto;
import com.ucompensar.tienda.dto.LoginResponseDto;
import com.ucompensar.tienda.services.LoginServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class LoginController {
    private final LoginServices loginServices;
    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto login) {
        return ResponseEntity.ok(loginServices.login(login));
    }
}
