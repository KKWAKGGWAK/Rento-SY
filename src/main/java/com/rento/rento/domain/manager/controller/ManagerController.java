package com.rento.rento.domain.manager.controller;

import com.rento.rento.common.apiresponse.ApiResponse;
import com.rento.rento.domain.manager.dto.request.ManagerDeleteRequest;
import com.rento.rento.domain.manager.dto.request.ManagerSignUpRequest;
import com.rento.rento.domain.manager.dto.request.ManagerUpdateRequest;
import com.rento.rento.domain.manager.dto.response.ManagerDeleteResponse;
import com.rento.rento.domain.manager.dto.response.ManagerResponse;
import com.rento.rento.domain.manager.dto.response.ManagerSignUpResponse;
import com.rento.rento.domain.manager.dto.response.ManagerUpdateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManagerController {

    ResponseEntity<ApiResponse<ManagerSignUpResponse>> signUp(ManagerSignUpRequest request);

    ResponseEntity<ApiResponse<ManagerResponse>> getManagerDetail(Long id);

    ResponseEntity<ApiResponse<List<ManagerResponse>>> getManagerList(String companyCode);

    ResponseEntity<ApiResponse<ManagerUpdateResponse>> update(Long id, ManagerUpdateRequest request) ;

    ResponseEntity<ApiResponse<ManagerDeleteResponse>> delete(Long id, ManagerDeleteRequest request);

    ResponseEntity<ApiResponse<Boolean>> checkAvailableLoginId(String loginId);

    ResponseEntity<ApiResponse<Boolean>> checkAvailableEmail(String email);
}
