package com.rashidi.transferservice.core.model;

import java.time.OffsetDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
public record Customer(
    long id,
    String name,
    String personNumber,
    OffsetDateTime createdAt) {

}
