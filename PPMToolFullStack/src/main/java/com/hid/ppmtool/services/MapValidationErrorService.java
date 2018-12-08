package com.hid.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rraigonde
 * @date 08-12-2018 12:35
 */
@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationError(BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors())
                errorMap.put(error.getField(), error.getDefaultMessage());
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
