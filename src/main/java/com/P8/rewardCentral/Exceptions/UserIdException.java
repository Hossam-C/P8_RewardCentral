package com.P8.rewardCentral.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdException extends Exception{

     public UserIdException(String s){
         super(s);
        }
}

