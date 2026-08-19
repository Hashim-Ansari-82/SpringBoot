package com.journel.exception;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ErrorResponse {

	private String name;
	private String status;
	private LocalDate date;
}
