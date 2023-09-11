package com.rashidi.transferservice.adapters.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rashidi.transferservice.core.model.Deposit;
import java.math.BigDecimal;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record DepositDto(
    String requestUid,
    long customerId,
    String fromAccountNumber,
    String toAccountNumber,
    String amount) {

  public Deposit toDomain() {
    return Deposit.builder()
        .requestUid(requestUid)
        .customerId(customerId)
        .fromAccountNumber(fromAccountNumber)
        .toAccountNumber(toAccountNumber)
        .amount(new BigDecimal(amount))
        .build();
  }
}
