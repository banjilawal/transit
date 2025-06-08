package com.lawal.transitcraft.infrastructure.avenue.exception;

public class NullAvenueException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  public static final String MESSAGE = "Avenue is null";

  public NullAvenueException (String message) {
    super(message);
  }
}