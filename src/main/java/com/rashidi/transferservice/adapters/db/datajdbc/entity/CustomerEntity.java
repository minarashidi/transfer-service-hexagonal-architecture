package com.rashidi.transferservice.adapters.db.datajdbc.entity;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@Table(schema = "transfer_service", name = "customer")
public class CustomerEntity {

  @Id
  Long id;
  String name;
  String personNumber;
  OffsetDateTime createdAt;

}
