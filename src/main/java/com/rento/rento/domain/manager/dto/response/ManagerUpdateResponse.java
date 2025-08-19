package com.rento.rento.domain.manager.dto.response;

import com.rento.rento.domain.manager.entity.Manager;

public record ManagerUpdateResponse(
        Long companyId,
        String name,
        String phone,
        String email,
        String loginId
) {
    public static ManagerUpdateResponse fromEntity(Manager manager) {
        return new ManagerUpdateResponse(manager.getCompany().getId(), manager.getName(),
                manager.getPhone(), manager.getEmail(), manager.getLoginId());
    }
}
