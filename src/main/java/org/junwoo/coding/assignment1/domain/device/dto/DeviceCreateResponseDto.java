package org.junwoo.coding.assignment1.domain.device.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.junwoo.coding.assignment1.domain.device.entity.Device;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupReadResponseDto;

@Getter
public class DeviceCreateResponseDto {

  private final Long deviceId;
  private final String serialNumber;
  private final StationGroupReadResponseDto stationGroup;
  private final LocalDateTime createdAt;

  public DeviceCreateResponseDto(final Device device, final StationGroupReadResponseDto stationGroupReadResponseDto) {
    this.deviceId = device.getId();
    this.serialNumber = device.getSerialNumber();
    this.stationGroup = stationGroupReadResponseDto;
    this.createdAt = device.getCreatedAt();
  }

}
