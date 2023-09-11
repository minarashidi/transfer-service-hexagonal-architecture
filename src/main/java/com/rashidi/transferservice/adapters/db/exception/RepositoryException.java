package com.rashidi.transferservice.adapters.db.exception;

import static com.rashidi.transferservice.core.model.ErrorCode.DATABASE_INTERNAL_ERROR;

import com.rashidi.transferservice.core.model.ErrorCode;
import com.rashidi.transferservice.core.model.exceptions.TransferServiceException;

public class RepositoryException extends TransferServiceException {

  public RepositoryException(ErrorCode errorCode, String description) {
    super(errorCode, description);
  }

  public RepositoryException() {
    super(DATABASE_INTERNAL_ERROR, "Internal database error");
  }

  public RepositoryException(String description, Throwable cause) {
    super(DATABASE_INTERNAL_ERROR, description, cause);
  }

}
