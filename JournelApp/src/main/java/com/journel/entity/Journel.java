package com.journel.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Journel {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	private String title;
	private String content;
	private LocalDateTime date;
}
