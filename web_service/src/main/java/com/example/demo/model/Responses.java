package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Responses {

    private String status;
    private String message;
    private Object data;
}
