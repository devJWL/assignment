package org.junwoo.coding.assignment1.domain.group.service;

import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupCreateResponseDto;
import org.junwoo.coding.assignment1.domain.group.dto.StationGroupReadResponseDto;
import org.junwoo.coding.assignment1.domain.group.entity.StationGroup;
import org.junwoo.coding.assignment1.domain.group.repository.StationGroupRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StationGroupService {

  private final StationGroupRepository stationGroupRepository;

  public StationGroupCreateResponseDto createStationGroup(final String stationGroupSerial) {

    StationGroup stationGroup = stationGroupRepository.save(
        StationGroup.builder()
            .serialNumber(stationGroupSerial)
            .build());

    return new StationGroupCreateResponseDto(stationGroup);
  }

  public StationGroupReadResponseDto readStationGroup(final String serialNumber) {
    StationGroup stationGroup = stationGroupRepository.findBySerialNumber(serialNumber);
    return new StationGroupReadResponseDto(stationGroup);
  }
}
