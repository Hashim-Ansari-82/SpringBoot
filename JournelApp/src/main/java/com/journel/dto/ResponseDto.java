package com.journel.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDto {

	private Integer Id;
	private String title;
	private String content;
	private LocalDateTime date;
}
