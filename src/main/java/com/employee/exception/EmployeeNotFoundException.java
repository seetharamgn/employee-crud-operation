package com.employee.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends CustomException{

    public EmployeeNotFoundException(){
        super(ErrorCode.EMPLOYEE_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}