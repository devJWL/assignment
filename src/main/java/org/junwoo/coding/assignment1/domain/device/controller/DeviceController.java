package org.junwoo.coding.assignment1.domain.device.controller;

import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.device.dto.DeviceCreateRequestDto;
import org.junwoo.coding.assignment1.domain.device.dto.DeviceCreateResponseDto;
import org.junwoo.coding.assignment1.domain.device.service.DeviceService;
import org.junwoo.coding.assignment1.global.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
@RestController
public class DeviceController {

  private final DeviceService deviceService;

  @PostMapping
  public Response<DeviceCreateResponseDto> createDevice(@RequestBody final DeviceCreateRequestDto deviceCreateRequestDto) {
    DeviceCreateResponseDto deviceCreateResponseDto = deviceService.createDevice(
        deviceCreateRequestDto);
    return Response.ok(deviceCreateResponseDto);
  }

}
