package com.lld.splitwise.exceptions;

public class InvalidSplitException extends RuntimeException {

  public InvalidSplitException() {
  }

  public InvalidSplitException(String message) {
    super(message);
  }

  public InvalidSplitException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidSplitException(Throwable cause) {
    super(cause);
  }

  public InvalidSplitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
