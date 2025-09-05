package com.workshop.errors;


public class Result<T> {
    private final boolean isSuccess;
    private final T data;
    private final ErrorCode error;

    public Result(boolean isSuccess, T data, ErrorCode error) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.error = error;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(ErrorCode error) {
        return new Result<>(false, null, error);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public T getData() {
        return data;
    }

    public ErrorCode getError() {
        return error;
    }
}
