package com.rento.rento.domain.event.entity;

import com.rento.rento.common.exception.DeviceException;
import com.rento.rento.domain.device.enums.DeviceResultCode;
import com.rento.rento.domain.device.enums.GpsCondition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Entity
@SuperBuilder
@Table(name = "events")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long deviceUniqueId;

    Long mdn;

    String terminalId;

    Integer makerId;

    Integer packetVersion;

    Integer deviceId;

    @Enumerated(EnumType.STRING)
    private GpsCondition gpsCondition;

    @Column(precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 9, scale = 6)
    private BigDecimal longitude;

    private Integer angle;

    private Integer speed;

    private Long currentAccumulatedDistance; //총 누적 거리

    public void validateMdnMatch(Long mdn) {
        if (!this.mdn.equals(mdn)) {
            throw new DeviceException(DeviceResultCode.MISMATCHED_MDN);
        }
    }
}
