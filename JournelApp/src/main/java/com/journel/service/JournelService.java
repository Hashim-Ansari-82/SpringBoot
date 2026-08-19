package com.journel.service;

import java.util.List;

import com.journel.dto.RequestDto;
import com.journel.dto.ResponseDto;

public interface JournelService {
   
     public ResponseDto save(RequestDto dto);
     public List<ResponseDto>  getAll();
     public ResponseDto getById(Integer id);
     public void delete(Integer id);
     public ResponseDto update(Integer id,RequestDto dto);
}
