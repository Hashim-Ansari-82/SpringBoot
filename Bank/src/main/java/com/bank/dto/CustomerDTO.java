package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	@NotEmpty(message = "Customer Id not empty")
	private int id;
	@NotBlank(message = "Customer name must be Enter")
	private String CustomerName;
	@NotNull(message = "Email not be Null")
	@Size(min = 4, max = 10 ,message = "Minimum 4 digit maximum 10 digit Enter" )
	private String email;
}
