package org.junwoo.coding.assignment1.domain.group.controller;

import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupCreateRequestDto;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupCreateResponseDto;
import org.junwoo.coding.assignment1.domain.group.service.StationGroupService;
import org.junwoo.coding.assignment1.global.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/station-groups")
@RestController
public class StationGroupController {

  private final StationGroupService stationGroupService;

  @PostMapping
  public Response<StationGroupCreateResponseDto> createStationGroup(@RequestBody final StationGroupCreateRequestDto stationGroupCreateRequestDto) {
    StationGroupCreateResponseDto data = stationGroupService.createStationGroup(stationGroupCreateRequestDto.getStationGroupSerial());
    return Response.ok(data);
  }

}
