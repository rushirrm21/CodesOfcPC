package com.jwtda.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponse {
   private String msg;
   private int code;
}