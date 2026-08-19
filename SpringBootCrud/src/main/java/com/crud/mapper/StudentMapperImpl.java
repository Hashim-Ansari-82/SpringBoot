package com.crud.mapper;

import com.crud.dto.ReqDto;
import com.crud.dto.RespDto;
import com.crud.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper{


    @Override
    public RespDto entityToDto(Student student) {
        RespDto dto = new RespDto();
        dto.setId(student.getId());
        dto.setAge(student.getAge());
        dto.setCollege(student.getCollege());
        dto.setCourse(student.getCourse());
        dto.setAddress(student.getAddress());
        dto.setGender(student.getGender());
        dto.setName(student.getName());
        dto.setGrade(student.getGrade());
        dto.setMobile(student.getMobile());
        dto.setNationality(student.getNationality());
        dto.setBloodGroup(student.getBloodGroup());
        dto.setPercentage(student.getPercentage());
        dto.setSemester(student.getSemester());
        return dto;
    }
    @Override
    public Student dtoToEntity(ReqDto dto) {
        Student st = new Student();
        st.setName(dto.getName());
        st.setEmail(dto.getEmail());
        st.setGender(dto.getGender());
        st.setAge(dto.getAge());
        st.setAddress(dto.getAddress());
        st.setCollege(dto.getCollege());
        st.setCourse(dto.getCourse());
        st.setNationality(dto.getNationality());
        st.setMobile(dto.getMobile());
        st.setGrade(dto.getGrade());
        st.setBloodGroup(dto.getBloodGroup());
        st.setSemester(dto.getSemester());
        st.setPercentage(dto.getPercentage());
        return  st;
    }
}
