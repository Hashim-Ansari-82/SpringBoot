package com.journel.mapper;

import com.journel.dto.RequestDto;
import com.journel.dto.ResponseDto;
import com.journel.entity.Journel;

public interface JournelMapper {

	public ResponseDto entityToDto(Journel journel);
	public Journel dtoToEntity(RequestDto dto);
}
