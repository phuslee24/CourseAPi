package com.example.demo.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseData<T> {
    public int statusCode;
    public String message;
    public String error;
    public T data;
}
