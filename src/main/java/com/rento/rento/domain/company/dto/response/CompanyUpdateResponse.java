package com.rento.rento.domain.company.dto.response;

import com.rento.rento.domain.company.entity.Company;

public record CompanyUpdateResponse(
        int bizNumber,
        String name
) {
    public static CompanyUpdateResponse fromEntity(Company company) {
        return new CompanyUpdateResponse(company.getBizNumber(), company.getName());
    }
}
