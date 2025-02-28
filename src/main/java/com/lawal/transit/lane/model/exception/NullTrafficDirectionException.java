package com.lawal.transit.lane.model.exception;

public class NullTrafficDirectionException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  public static final String MESSSAGE = "Lane direction cannot be null or empty";

  public NullTrafficDirectionException (String message) {
    super(message);
  }
}