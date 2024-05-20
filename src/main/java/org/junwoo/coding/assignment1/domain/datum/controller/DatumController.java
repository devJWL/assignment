package org.junwoo.coding.assignment1.domain.datum.controller;

import lombok.RequiredArgsConstructor;
import org.junwoo.coding.assignment1.domain.datum.dto.DatumCreateRequestDto;
import org.junwoo.coding.assignment1.domain.datum.service.DatumService;
import org.junwoo.coding.assignment1.global.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/datums")
@RestController
public class DatumController {

  private final DatumService datumService;

  @PostMapping
  public Response<Void> createDatum(@RequestBody final DatumCreateRequestDto datumCreateRequestDto) {
    datumService.createDatum(datumCreateRequestDto);
    return Response.ok(null);
  }

}
