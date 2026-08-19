package com.crud.service;

import com.crud.dto.ReqDto;
import com.crud.dto.RespDto;

import java.util.List;

public interface StudentService {


    RespDto save(ReqDto dto);
    List<RespDto> getAll();
    RespDto getById(Integer id);
    void delete(Integer id);
    RespDto update(Integer id,ReqDto dto);
    Boolean softDelete(Integer id);
}
