package backend.developer.progectjbd.domain.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ c токеном доступа")
public record AuthResponse(
    String token
){}
