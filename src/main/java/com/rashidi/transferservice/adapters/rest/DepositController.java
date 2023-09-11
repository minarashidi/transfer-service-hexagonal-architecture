package com.rashidi.transferservice.adapters.rest;

import com.rashidi.transferservice.adapters.rest.dto.DepositDto;
import com.rashidi.transferservice.core.ports.DepositService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/transfer-service", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class DepositController {

  private final DepositService depositService;

  @PostMapping(path = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> add(@RequestBody DepositDto dto) {
    depositService.add(dto.toDomain());
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(dto.requestUid());
  }
}
