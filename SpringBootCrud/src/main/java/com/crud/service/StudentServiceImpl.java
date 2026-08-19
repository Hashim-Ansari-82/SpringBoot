package com.crud.service;

import com.crud.dto.ReqDto;
import com.crud.dto.RespDto;
import com.crud.entity.Student;
import com.crud.mapper.StudentMapper;
import com.crud.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepo rep;
	private final StudentMapper mapper;

	@Override
	public RespDto save(ReqDto dto) {

		Student student = mapper.dtoToEntity(dto);
		// student.setDeleted(false);
		Student save = rep.save(student);
		return mapper.entityToDto(save);

	}

	@Override
	public List<RespDto> getAll() {
		List<Student> all = rep.findByDeletedFalse();

		ArrayList<RespDto> dto = new ArrayList<>();

		for (Student s : all) {
			dto.add(mapper.entityToDto(s));
		}

		return dto;
	}

	@Override
	public RespDto getById(Integer id) {

		Student student = rep.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new RuntimeException("Not found this id " + id));

		return mapper.entityToDto(student);

	}

	@Override
	public void delete(Integer id) {

		rep.deleteById(id);

	}

	@Override
	public Boolean softDelete(Integer id) {

		Optional<Student> exStu = rep.findByIdAndDeletedFalse(id);

		if (exStu != null) {
			Student student = exStu.get();
			student.setDeleted(true);
			rep.save(student);

			return true;
		}

		return false;
	}

	@Override
	public RespDto update(Integer id, ReqDto dto) {

		Student exStu = rep.findByIdAndDeletedFalse(id).orElseThrow(() -> new RuntimeException("Not found"));

		exStu.setName(dto.getName());
		exStu.setEmail(dto.getEmail());
		exStu.setGender(dto.getGender());
		exStu.setAge(dto.getAge());
		exStu.setAddress(dto.getAddress());
		exStu.setCourse(dto.getCourse());
		exStu.setNationality(dto.getNationality());
		exStu.setMobile(dto.getMobile());
		exStu.setGrade(dto.getGrade());
		exStu.setBloodGroup(dto.getBloodGroup());
		exStu.setCollege(dto.getCollege());

		exStu.setDeleted(false);

		Student save = rep.save(exStu);

		return mapper.entityToDto(save);
	}

}
