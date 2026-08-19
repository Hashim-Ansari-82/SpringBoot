package com.journel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestDto {

	@NotBlank(message = "Title is required")
	private String title;
	@NotBlank(message = "Content is Required")
	private String content;
}
