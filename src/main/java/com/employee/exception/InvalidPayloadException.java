package com.employee.exception;

import org.springframework.http.HttpStatus;

public class InvalidPayloadException extends CustomException{

    public InvalidPayloadException(){
        super(ErrorCode.INVALID_PAYLOAD, HttpStatus.BAD_REQUEST);
    }
}
