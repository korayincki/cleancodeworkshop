package com.workshop.errors;

public record ErrorCode(String code) {
    public static ErrorCode NOT_FOUND = new ErrorCode("NOT_FOUND");
    public static ErrorCode INSUFFICIENT_STOCK = new ErrorCode("INSUFFICIENT_STOCK");
}
