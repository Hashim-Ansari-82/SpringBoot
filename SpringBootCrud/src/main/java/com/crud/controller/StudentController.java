package com.crud.controller;

import com.crud.dto.ReqDto;
import com.crud.dto.RespDto;
import com.crud.entity.Student;
import com.crud.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;

	@PostMapping
	public ResponseEntity<RespDto> save(@Valid @RequestBody ReqDto dto) {

		RespDto save = service.save(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

	@GetMapping
	public ResponseEntity<List<RespDto>> getAll() {

		List<RespDto> all = service.getAll();

		return ResponseEntity.ok(all);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespDto> getById(@PathVariable Integer id) {

		Student student = new Student();
		
		if (id != null) { 
			RespDto byId = service.getById(id);
		 return	ResponseEntity.ok(byId);
		} 

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.ok("Deleted Successfully " + id);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> softDelete(@PathVariable Integer id) {

		Boolean isDeleted = service.softDelete(id);
		if (!isDeleted) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok("Soft Deleted Successfully " + id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RespDto> update(@PathVariable Integer id, @RequestBody ReqDto dto) {

		RespDto update = service.update(id, dto);

		return ResponseEntity.ok(update);
	}
}
