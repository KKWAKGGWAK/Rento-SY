package com.rento.rento.domain.company.dto.response;

import com.rento.rento.domain.company.entity.Company;

public record CompanyRegisterResponse(
        String name,
        String code
) {
    public static CompanyRegisterResponse fromEntity(Company company) {
        return new CompanyRegisterResponse(company.getName(), company.getCompanyCode());
    }
}
