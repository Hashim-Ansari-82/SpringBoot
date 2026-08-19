package com.journel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journel.dto.RequestDto;
import com.journel.dto.ResponseDto;
import com.journel.service.JournelService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("journel")
public class JournelController {
	
	private final JournelService service;
		   
	@PostMapping
	public ResponseDto save(@Valid @RequestBody RequestDto dto) {
		return service.save(dto);
	}
    
	@GetMapping
	public List<ResponseDto> getAll() {
      return service.getAll();
	}
    @GetMapping("/{id}")
	public ResponseDto getById(@PathVariable Integer id) {
		return service.getById(id);
	}
    @DeleteMapping("/{id}")
	public String  delete(@PathVariable Integer id) {
		service.delete(id);
		return "Deleted Successfully";
	}
    @PutMapping("/{id}")
	public ResponseDto update(@PathVariable Integer id, @RequestBody RequestDto dto) {
		return service.update(id, dto);
	}
}
