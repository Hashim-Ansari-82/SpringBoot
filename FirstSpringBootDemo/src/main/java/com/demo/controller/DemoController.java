package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {

	private Map<Integer,Demo>  demo1= new HashMap<>();
	
	@PostMapping
	public Demo save(@RequestBody Demo demo) {
		demo1.put(demo.getId(),demo);
		return demo;
	}
	@GetMapping
	public List<Demo>  getAll(){
		return new ArrayList<>(demo1.values());
	}
	@GetMapping("/{id}")
	public Demo  getById(@PathVariable Integer id) {
		return demo1.get(id);
	}
	@DeleteMapping("/{id}")
	public Demo  deleteById(@PathVariable Integer id) {
		return demo1.remove(id);
	}
	@PutMapping("/{id}")
	public Demo  deleteById(@PathVariable Integer id,@RequestBody Demo demo) {
		return demo1.put(id,demo);
	}
}
