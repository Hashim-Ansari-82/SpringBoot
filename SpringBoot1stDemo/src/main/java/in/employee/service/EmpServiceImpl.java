package in.employee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import in.employee.dto.ReqDto;
import in.employee.dto.RespDto;
import in.employee.entity.Employee;
import in.employee.exception.DuplicateResourceException;
import in.employee.exception.ResourceNotFoundException;
import in.employee.mapper.EmpMapper;
import in.employee.repository.EmpRep;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    private final EmpRep repo;
    private final EmpMapper mapper;

    @Override
    public RespDto save(ReqDto dto) {

        Employee emp = mapper.dtoToEntity(dto);
        if(existsByEmail(dto)) {
          	throw new DuplicateResourceException
          	("Employee with email "+dto.getEmail()+" already exists");
          }
        Employee save = repo.save(emp);

        return mapper.entityToDto(save);
    }

    @Override
    public List<RespDto> getAll() {

       List<RespDto> list = repo.findByDeletedFalse().stream()
    		   .map(mapper::entityToDto).toList();

        return list;
    }

    @Override
    public RespDto getById(Integer id) {

        Employee employee = repo.findByIdAndDeletedFalse(id).orElseThrow(() ->
                new ResourceNotFoundException("No any record on this id " + id));

        return mapper.entityToDto(employee);

    }

    @Override
    public void delete(Integer id) {

    	Employee employee = repo.findById(id).orElseThrow(() 
    	-> new ResourceNotFoundException("Employee not found on this id "+id));
    	
       repo.delete(employee);
    }

    @Override
    public void softDelete(Integer id) {

        Employee emp = repo.findByIdAndDeletedFalse(id).orElseThrow(() ->
                new ResourceNotFoundException("No any record on this id " + id));


        emp.setDeleted(true);
        emp.setUpdatedAt(LocalDateTime.now());
        emp.setUpdatedAt(LocalDateTime.now());
        repo.save(emp);

    }

    @Override
    public RespDto update(Integer id, ReqDto dto) {

        Employee exEmp = repo.findByIdAndDeletedFalse(id).orElseThrow(() ->
        new ResourceNotFoundException("No any record on this id " + id));

        exEmp.setName(dto.getName());
        exEmp.setAddress(dto.getAddress());
        exEmp.setEmail(dto.getEmail());
        exEmp.setDepartment(dto.getDepartment());
        exEmp.setSalary(dto.getSalary());
        exEmp.setMobile(dto.getMobile());
        
        Employee save = repo.save(exEmp);

        return mapper.entityToDto(save);
    }

	@Override
	public boolean existsByEmail(ReqDto dto) {

			boolean exitsByEmail = repo.existsByEmail(dto.getEmail());
		
		return exitsByEmail;
	}
	
	@Override
	public RespDto restore(Integer id) {
		
		Employee emp = repo.findByIdAndDeletedTrue(id).orElseThrow(() ->
		new ResourceNotFoundException("This id is not mark to soft deleted "+id));
		
		emp.setDeleted(false);
		
		Employee save = repo.save(emp);
		return mapper.entityToDto(save);
	}
    
}
