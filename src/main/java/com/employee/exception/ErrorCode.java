package com.employee.exception;

public enum ErrorCode {

    /**
     * {@code EMPLOYEE_NOT_FOUND}.
     */
    EMPLOYEE_NOT_FOUND,
    /**
     * {@code INVALID_ARGUMENTS}.
     */
    INVALID_ARGUMENTS,

    /**
     * {@code INVALID_PAYLOAD}.
     */
    INVALID_PAYLOAD;
    private String servicePrefix = "SODSRVC";

    public String code() {

        StringBuilder errorCode = new StringBuilder();
        // @formatter:off
        errorCode
                .append(this.servicePrefix)
                .append('.')
                .append(this);
        // @formatter:on
        return errorCode.toString();
    }




}
