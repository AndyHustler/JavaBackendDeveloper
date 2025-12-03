package backend.developer.progectjbd.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.developer.progectjbd.auth.service.AuthService;
import backend.developer.progectjbd.domain.dto.auth.AuthResponse;
import backend.developer.progectjbd.domain.dto.auth.SignInRequest;
import backend.developer.progectjbd.domain.dto.auth.SignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public AuthResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public AuthResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authService.signIn(request);
    }
}
