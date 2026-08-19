package in.employee.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.employee.dto.ReqDto;
import in.employee.dto.RespDto;
import in.employee.service.EmpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService service;

    @PostMapping
    ResponseEntity<RespDto> save(@Valid @RequestBody ReqDto dto) {

        RespDto respDto = service.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(respDto);
    }

    @GetMapping
    ResponseEntity<List<RespDto>> getAll() {

        List<RespDto> respDto = service.getAll();

        return ResponseEntity.ok(respDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<RespDto> getById(@PathVariable Integer id) {

        RespDto resId = service.getById(id);

        return ResponseEntity.ok(resId);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
    }

    @PutMapping("/{id}")
    ResponseEntity<RespDto> update(@PathVariable Integer id, @RequestBody ReqDto dto) {
        RespDto respDto = service.update(id, dto);
        return ResponseEntity.ok(respDto);
    }

    @PatchMapping("/{id}")
    ResponseEntity<String> softDelete(@PathVariable Integer id) {

      service.softDelete(id);

      return ResponseEntity.status(HttpStatus.OK).body("Employee soft Deleted Successfully");
    }
    
    @PutMapping("/restore/{id}")
    ResponseEntity<RespDto> restore(@PathVariable Integer id) {
    	
    	RespDto respDto = service.restore(id);
    	
    	return ResponseEntity.ok(respDto);
    }
}
