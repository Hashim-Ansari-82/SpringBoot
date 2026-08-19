package com.crud.mapper;

import com.crud.dto.ReqDto;
import com.crud.dto.RespDto;
import com.crud.entity.Student;

public interface StudentMapper {

    Student dtoToEntity(ReqDto dto);
    RespDto entityToDto(Student student);
}
