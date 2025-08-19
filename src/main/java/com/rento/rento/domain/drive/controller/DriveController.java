package com.rento.rento.domain.drive.controller;

import com.rento.rento.common.apiresponse.ApiResponse;
import com.rento.rento.domain.drive.dto.DriveAddRequest;
import com.rento.rento.domain.drive.dto.DriveDetailResponse;
import com.rento.rento.domain.drive.dto.DriveResponse;
import com.rento.rento.domain.manager.dto.details.CustomManagerDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriveController {

    ResponseEntity<ApiResponse<String>> driveAdd(DriveAddRequest request);
    ResponseEntity<ApiResponse<String>> driveStart(Long driveId);
    ResponseEntity<ApiResponse<String>> driveEnd(Long driveId);
    ResponseEntity<ApiResponse<String>> driveCancel(Long driveId);
    ResponseEntity<ApiResponse<List<DriveResponse>>> getDriveList(CustomManagerDetails manager);
    ResponseEntity<ApiResponse<DriveDetailResponse>> getDriveDetail(Long driveId);
}
