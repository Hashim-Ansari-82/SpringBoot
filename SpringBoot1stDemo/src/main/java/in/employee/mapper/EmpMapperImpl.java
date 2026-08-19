package in.employee.mapper;

import in.employee.dto.ReqDto;
import in.employee.dto.RespDto;
import in.employee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmpMapperImpl implements EmpMapper{

    @Override
    public RespDto entityToDto(Employee emp) {

        RespDto dto = new RespDto();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setAddress(emp.getAddress());
        dto.setMobile(emp.getMobile());
        dto.setEmail(emp.getEmail());
        dto.setSalary(emp.getSalary());
        dto.setDepartment(emp.getDepartment());
        dto.setMessage("Employee save Successfully");
        dto.setCreatedAt(emp.getCreatedAt());
        dto.setUpdatedAt(emp.getUpdatedAt());

        return dto;
    }

    @Override
    public Employee dtoToEntity(ReqDto dto) {

        Employee emp = new Employee();

        emp.setName(dto.getName());
        emp.setAddress(dto.getAddress());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        emp.setMobile(dto.getMobile());

        return emp;
    }
}
