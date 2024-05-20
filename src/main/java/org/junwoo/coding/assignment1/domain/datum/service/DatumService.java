package org.junwoo.coding.assignment1.domain.datum.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.datum.dto.DatumCreateRequestDto;
import org.junwoo.coding.assignment1.domain.datum.entity.Datum;
import org.junwoo.coding.assignment1.domain.datum.repository.DatumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DatumService {

  private final DatumRepository datumRepository;

  public void createDatum(final DatumCreateRequestDto datumCreateRequestDto) {
    List<Datum> dataSet = convertData(
        datumCreateRequestDto.getSerialNumber(),
        datumCreateRequestDto.getInterval(),
        datumCreateRequestDto.getDataSet(),
        datumCreateRequestDto.getRecordedAt());

    datumRepository.saveAll(dataSet);
  }

  private List<Datum> convertData(final String serialNumber, final Long interval, final String dataSet, final LocalDateTime startedAt) {
    List<Long> datumValues = tokenize(dataSet).stream().map(this::getInvalidValue).toList();
    LocalDateTime recordedAt = startedAt;
    List<Datum> data = new ArrayList<>();

    for (Long datumValue : datumValues) {
      data.add(Datum.builder()
              .serialNumber(serialNumber)
              .datumValue(datumValue)
              .recordedAt(recordedAt)
          .build());
      recordedAt = recordedAt.plusMinutes(interval);
    }
    return data;
  }

  private List<String> tokenize(final String dataSet) {
    List<String> tokens = new ArrayList<>();
    StringBuilder token = new StringBuilder();

    for (int i = 0; i < dataSet.length(); ++i) {
      token.append(dataSet.charAt(i));

      if (i % 4 == 3) {
        tokens.add(token.toString());
        token.delete(0, token.length());
      }
    }
    return tokens;
  }

  private Long getInvalidValue(final String token) {
    final long adjustmentValue = 1L << 16;
    final long overflow = 1L << 15;
    long value = Long.parseLong(token, 16);

    return value < overflow ? value : value - adjustmentValue;
  }
}
