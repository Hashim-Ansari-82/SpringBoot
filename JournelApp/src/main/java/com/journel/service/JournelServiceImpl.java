package com.journel.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.journel.dto.RequestDto;
import com.journel.dto.ResponseDto;
import com.journel.entity.Journel;
import com.journel.mapper.JournelMapper;
import com.journel.repository.JournelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JournelServiceImpl implements JournelService{

	private final JournelRepository repository;
	private final JournelMapper mapper;
	
	@Override
	public ResponseDto save(RequestDto dto) {
		
		
		Journel entityToDto = mapper.dtoToEntity(dto);
		entityToDto.setDate(LocalDateTime.now());
		Journel save = repository.save(entityToDto);
      
		return mapper.entityToDto(save);
	}

	@Override
	public List<ResponseDto> getAll() {

//		List<ResponseDto> list = repository.findAll().stream().map(mapper::dtoToEntity).toList();
		List<Journel> entity = repository.findAll();
		List<ResponseDto> list = new ArrayList<>();
		
		for(Journel entities:entity) {
			list.add(mapper.entityToDto(entities));
		}
		
		return list;
	}

	@Override
	public ResponseDto getById(Integer id) {
		
		Journel journel = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		
		return mapper.entityToDto(journel);
	}

	@Override
	public void delete(Integer id) {
		
     Journel j = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
		repository.delete(j);
	}

	@Override
	public ResponseDto update(Integer id, RequestDto dto) {
		Journel journel = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		 journel.setTitle(dto.getTitle());
		 journel.setContent(dto.getContent());
		 journel.setDate(LocalDateTime.now());
		 Journel save = repository.save(journel);
		 
		return mapper.entityToDto(save);
	}

}
