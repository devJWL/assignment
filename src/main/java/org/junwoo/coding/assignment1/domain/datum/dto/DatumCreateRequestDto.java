package org.junwoo.coding.assignment1.domain.datum.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class DatumCreateRequestDto {

  private String serialNumber;
  private Long interval;
  private String dataSet;
  private LocalDateTime recordedAt;

}
