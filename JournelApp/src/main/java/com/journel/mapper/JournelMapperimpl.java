package com.journel.mapper;

import org.springframework.stereotype.Component;

import com.journel.dto.RequestDto;
import com.journel.dto.ResponseDto;
import com.journel.entity.Journel;

@Component
public class JournelMapperimpl implements JournelMapper{


	@Override
	public Journel dtoToEntity(RequestDto dto) {
		Journel journel = new Journel();
		journel.setTitle(dto.getTitle());
		journel.setContent(dto.getContent());
		return journel;
	}
	
	@Override
	public ResponseDto entityToDto(Journel journel) {
		ResponseDto dto = new ResponseDto();
		dto.setId(journel.getId());
		dto.setTitle(journel.getTitle());
		dto.setContent(journel.getContent());
		dto.setDate(journel.getDate());
		return dto;
	}


}
