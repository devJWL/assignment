package org.junwoo.coding.assignment1.domain.device.service;

import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.device.dto.DeviceCreateRequestDto;
import org.junwoo.coding.assignment1.domain.device.dto.DeviceCreateResponseDto;
import org.junwoo.coding.assignment1.domain.device.entity.Device;
import org.junwoo.coding.assignment1.domain.device.repository.DeviceRepository;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupReadResponseDto;
import org.junwoo.coding.assignment1.domain.group.service.StationGroupService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceService {

  private final StationGroupService stationGroupService;
  private final DeviceRepository deviceRepository;

  public DeviceCreateResponseDto createDevice(DeviceCreateRequestDto deviceCreateRequestDto) {

    StationGroupReadResponseDto stationGroupReadResponseDto = stationGroupService.readStationGroup(
        deviceCreateRequestDto.getStationGroupSerial());

    Device device = deviceRepository.save(Device.builder()
            .serialNumber(deviceCreateRequestDto.getSerialNumber())
            .stationGroupId(stationGroupReadResponseDto.getStationGroupId())
        .build());

    return new DeviceCreateResponseDto(device, stationGroupReadResponseDto);
  }
}
