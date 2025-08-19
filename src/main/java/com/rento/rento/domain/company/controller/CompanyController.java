package com.rento.rento.domain.company.controller;

import com.rento.rento.common.apiresponse.ApiResponse;
import com.rento.rento.domain.company.dto.request.CompanyBiznumberRequest;
import com.rento.rento.domain.company.dto.request.CompanyRegisterRequest;
import com.rento.rento.domain.company.dto.request.CompanyUpdateRequest;
import com.rento.rento.domain.company.dto.response.CompanyDeleteResponse;
import com.rento.rento.domain.company.dto.response.CompanyRegisterResponse;
import com.rento.rento.domain.company.dto.response.CompanyResponse;
import com.rento.rento.domain.company.dto.response.CompanyUpdateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyController {

    ResponseEntity<ApiResponse<CompanyRegisterResponse>> register(CompanyRegisterRequest request);

    ResponseEntity<ApiResponse<CompanyResponse>> getCompanyDetail(Long id);

    ResponseEntity<ApiResponse<List<CompanyResponse>>> getCompanyList();

    ResponseEntity<ApiResponse<CompanyUpdateResponse>> updateCompanyInfo(Long id, CompanyUpdateRequest request);

    ResponseEntity<ApiResponse<Boolean>> checkAvailableBizNumber(CompanyBiznumberRequest request);

    ResponseEntity<ApiResponse<CompanyDeleteResponse>> companyDelete(Long id);
}
