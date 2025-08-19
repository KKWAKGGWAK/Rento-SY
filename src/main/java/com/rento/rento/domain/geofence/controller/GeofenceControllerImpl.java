package com.rento.rento.domain.geofence.controller;

import com.rento.rento.common.apiresponse.ApiResponse;
import com.rento.rento.common.apiresponse.ApiResultCode;
import com.rento.rento.common.apiresponse.ResEntityFactory;
import com.rento.rento.domain.geofence.dto.request.GeofenceRegisterRequest;
import com.rento.rento.domain.geofence.dto.request.GeofenceUpdateRequest;
import com.rento.rento.domain.geofence.dto.response.GeofenceInfoResponse;
import com.rento.rento.domain.geofence.entity.Geofence;
import com.rento.rento.domain.geofence.service.GeofenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/geofences")
public class GeofenceControllerImpl implements GeofenceController{

    private final GeofenceService geofenceService;

    @Override
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@RequestBody @Valid
                                                          GeofenceRegisterRequest request) {
        Geofence geofence = GeofenceRegisterRequest.toEntity(request);
        geofenceService.register(geofence);

        return ResEntityFactory.toResponse(ApiResultCode.SUCCESS, null);
    }

    @Override
    @GetMapping("/get-list/{companyCode}")
    public ResponseEntity<ApiResponse<List<GeofenceInfoResponse>>> getList(@PathVariable String companyCode) {
        List<Geofence> geofenceList = geofenceService.getGeofenceList(companyCode);

        return ResEntityFactory.toResponse(ApiResultCode.SUCCESS, GeofenceInfoResponse.fromEntity(geofenceList));
    }

    @Override
    @GetMapping("/get-detail/{id}")
    public ResponseEntity<ApiResponse<GeofenceInfoResponse>> getDetail(@PathVariable Long id) {

        return ResEntityFactory.toResponse(ApiResultCode.SUCCESS,
                GeofenceInfoResponse.fromEntity(geofenceService.getGeofenceDetail(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        geofenceService.delete(id);

        return ResEntityFactory.toResponse(ApiResultCode.SUCCESS, null);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> update(@PathVariable Long id,
                                                    @RequestBody @Valid GeofenceUpdateRequest request) {
        geofenceService.update(id, request);

        return ResEntityFactory.toResponse(ApiResultCode.SUCCESS, null);
    }
}
