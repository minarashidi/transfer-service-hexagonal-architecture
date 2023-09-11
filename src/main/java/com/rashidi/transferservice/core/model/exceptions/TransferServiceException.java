package com.rashidi.transferservice.core.model.exceptions;

import com.rashidi.transferservice.core.model.ErrorCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.logging.LogLevel;

@Getter
@ToString
public class TransferServiceException extends RuntimeException {

  private final ErrorCode errorCode;
  private final String description;

  public TransferServiceException(ErrorCode errorCode, String description) {
    super(String.format("Error Code: %s, Description: %s", errorCode, description));
    this.errorCode = errorCode;
    this.description = description;
  }

  public TransferServiceException(ErrorCode errorCode, String description, Throwable cause) {
    super(String.format("Error Code: %s, Description: %s", errorCode, description), cause);
    this.errorCode = errorCode;
    this.description = description;
  }

}
