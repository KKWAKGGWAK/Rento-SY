package com.rento.rento.domain.manager.dto.response;

import com.rento.rento.domain.manager.entity.Manager;

public record ManagerSignUpResponse(
        Long id,
        String loginId,
        String companyCode
) {
    public static ManagerSignUpResponse fromEntity(Manager manager) {
        return new ManagerSignUpResponse(manager.getId(), manager.getLoginId(), manager.getCompanyCode());
    }
}
