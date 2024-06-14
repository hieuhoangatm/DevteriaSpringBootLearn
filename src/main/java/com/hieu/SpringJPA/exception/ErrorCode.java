package com.hieu.SpringJPA.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"uncategorized error"),
    USER_EXISTED(1002,"User existed"),
    USERNAME_INVALID(1003,"Username must be at least 3 characters"),

    PASSWORD_INVALID(1004,"Password must be at least 6 characters"),
    USER_NOT_EXISTED(1005,"User not existed")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
