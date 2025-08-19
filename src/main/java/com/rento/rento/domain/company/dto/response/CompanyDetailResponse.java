package com.rento.rento.domain.company.dto.response;

import com.rento.rento.domain.company.entity.Company;

public record CompanyDetailResponse(
        Long id,
        String name,
        int bizNumber,
        String companyCode
) {
    public static CompanyDetailResponse fromEntity(Company company) {
        return new CompanyDetailResponse(company.getId(), company.getName(),
                company.getBizNumber(), company.getCompanyCode());
    }
}
