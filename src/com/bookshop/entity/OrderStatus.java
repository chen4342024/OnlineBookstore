package com.bookshop.entity;

public class OrderStatus {
  public static final int WAIT_AUDIT = 0;
  public static final int AUDIT_SUCCESS = 1;
  public static final int AUDIT_FAIL = 2;
  public static final int DELIVERY_SUCCESS  = 3;
  public static final int DEAL_COMPLETE = 4;
  public static final int CANCELED = 5;
}
