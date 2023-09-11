package com.rashidi.transferservice.adapters.db.datajdbc.entity;

import com.rashidi.transferservice.core.model.Deposit;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@Table(schema = "transfer_service", name = "deposit")
public class DepositEntity {

  @Id
  long id;
  String requestUid;
  long customerId;
  String fromAccountNumber;
  String toAccountNumber;
  BigDecimal amount;
  LocalDateTime createdAt;

  public Deposit toDeposit() {
    return Deposit.builder()
        .id(id)
        .customerId(customerId)
        .fromAccountNumber(fromAccountNumber)
        .toAccountNumber(toAccountNumber)
        .amount(amount)
        .build();
  }

  public static DepositEntity fromDeposit(Deposit deposit) {
    return DepositEntity.builder()
        .id(deposit.id())
        .requestUid(deposit.requestUid())
        .customerId(deposit.customerId())
        .fromAccountNumber(deposit.fromAccountNumber())
        .toAccountNumber(deposit.toAccountNumber())
        .amount(deposit.amount())
        .createdAt(LocalDateTime.now())
        .build();
  }
}
