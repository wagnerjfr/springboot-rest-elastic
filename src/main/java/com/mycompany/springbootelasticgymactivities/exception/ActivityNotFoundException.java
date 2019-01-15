package com.mycompany.springbootelasticgymactivities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends RuntimeException {

    public ActivityNotFoundException(String id) {
        super(String.format("Activity %s not found", id));
    }
}
