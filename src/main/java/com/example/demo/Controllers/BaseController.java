package com.example.demo.Controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.Utils.ResponseData;

@Component
public class BaseController<T> {
    public ResponseEntity<ResponseData<T>> Ok(T obj) {
        return ResponseEntity.ok(new ResponseData<>(200, "Action Succesfull", null, obj));
    };

    public ResponseEntity<ResponseData<T>> Error(T obj, int status, String message) {
        var response = new ResponseData<>(status, message, null, obj);
        switch (status) {
            case 400:
                response.error = "BadRequest";
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
            case 401:
                response.error = "Authortication";
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
            case 404:
                response.error = "Not Found";
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
            case 409:
                response.error = "Conflict";
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
            case 500:
                response.error = "Service Error";
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
            default:
                return ResponseEntity.status(HttpStatusCode.valueOf(status)).body(response);
        }
    };
}