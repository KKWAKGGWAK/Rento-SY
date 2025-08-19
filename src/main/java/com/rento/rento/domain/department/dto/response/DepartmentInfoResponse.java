package com.rento.rento.domain.department.dto.response;

import com.rento.rento.domain.department.entity.Department;

public record DepartmentInfoResponse(
        Long departmentId,
        String departmentName,
        int numberOfEmployees
) {
    public static   DepartmentInfoResponse fromEntity(Department department) {
        return new DepartmentInfoResponse(
                department.getId(),
                department.getDepartmentName(),
                department.getNumberOfEmployee()
        );
    }
}
