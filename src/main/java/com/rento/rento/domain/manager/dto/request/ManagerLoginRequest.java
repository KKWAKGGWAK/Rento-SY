package com.rento.rento.domain.manager.dto.request;

public record ManagerLoginRequest(
        String loginId,
        String password
) {
}
