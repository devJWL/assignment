package org.junwoo.coding.assignment1.domain.group.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.junwoo.coding.assignment1.domain.group.entity.StationGroup;

@Getter
public class StationGroupCreateResponseDto {

  private final Long stationGroupId;
  private final String serialNumber;
  private final LocalDateTime createdAt;

  public StationGroupCreateResponseDto(final StationGroup stationGroup) {
    this.stationGroupId = stationGroup.getId();
    this.serialNumber = stationGroup.getSerialNumber();
    this.createdAt = stationGroup.getCreatedAt();
  }

}
