package backend.developer.progectjbd.auth.service;

import lombok.RequiredArgsConstructor;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.developer.progectjbd.domain.dto.auth.AuthResponse;
import backend.developer.progectjbd.domain.dto.auth.SignInRequest;
import backend.developer.progectjbd.domain.dto.auth.SignUpRequest;
import backend.developer.progectjbd.domain.model.ERole;
import backend.developer.progectjbd.domain.model.User;
import backend.developer.progectjbd.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtTokenService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public AuthResponse signUp(SignUpRequest request) {

        User user = new User();
        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(ERole.ROLE_USER));

        userService.createUser(user);

        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public AuthResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        User user = userService.findByUserName(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}
