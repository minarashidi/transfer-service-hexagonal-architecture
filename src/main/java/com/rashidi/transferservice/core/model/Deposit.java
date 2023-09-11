package com.rashidi.transferservice.core.model;

import java.math.BigDecimal;
import lombok.Builder;

@Builder(toBuilder = true)
public record Deposit(long id,
                      String requestUid,
                      long customerId,
                      String fromAccountNumber,
                      String toAccountNumber,
                      BigDecimal amount) {
}