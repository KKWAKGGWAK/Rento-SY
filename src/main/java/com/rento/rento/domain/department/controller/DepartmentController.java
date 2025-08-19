package com.rento.rento.domain.department.controller;

import com.rento.rento.common.apiresponse.ApiResponse;
import com.rento.rento.domain.department.dto.request.DepartmentRegisterRequest;
import com.rento.rento.domain.department.dto.request.DepartmentUpdateRequest;
import com.rento.rento.domain.department.dto.response.DepartmentInfoResponse;
import com.rento.rento.domain.manager.dto.details.CustomManagerDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentController {

    //부서 등록
    ResponseEntity<ApiResponse<String>> registerDepartment(CustomManagerDetails manager, DepartmentRegisterRequest departmentRegisterRequest);
    //부서 목록 조회
    ResponseEntity<ApiResponse<List<DepartmentInfoResponse>>> getAllDepartments(String companyCode);
    //부서 수정
    ResponseEntity<ApiResponse<DepartmentInfoResponse>> updateDepartment (CustomManagerDetails manager, Long departmentId, DepartmentUpdateRequest departmentUpdateRequest);
    //부서 삭제
    ResponseEntity<ApiResponse<String>> deleteDepartment (CustomManagerDetails manager, Long departmentId);

}
