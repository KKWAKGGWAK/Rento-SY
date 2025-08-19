package com.rento.rento.domain.manager.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ManagerDeleteRequest(
        @NotBlank
        String loginId,

        @NotBlank
        String password
) {
}
