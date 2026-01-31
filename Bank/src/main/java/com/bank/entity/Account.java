package com.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

	@Id
	@Column(name="Account_Number")
	private int accountNo;
	private String Name;
	private String branch;
	private String accountType;
}
