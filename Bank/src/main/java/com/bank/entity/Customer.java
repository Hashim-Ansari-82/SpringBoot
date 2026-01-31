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
@Setter @Getter @ToString
@AllArgsConstructor 
@NoArgsConstructor
public class Customer extends BaseEntity{

	@Id
	@Column(name = "Customer_Id")
	private int id;
	private String CustomerName;
	@Column(name = "Customer_Email")
	private String email;
}
