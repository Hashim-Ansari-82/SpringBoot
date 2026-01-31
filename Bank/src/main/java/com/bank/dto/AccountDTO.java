package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {
	
	@NotEmpty(message = "Account Number not Empty")
	private int accountNo;
	@NotBlank(message = "Account name must be declared")
	private String Name;
	@NotNull(message = "Branch not null")
	private String branch;
	@NotBlank(message = "Account Type compulsary")
	private String accountType;
}
