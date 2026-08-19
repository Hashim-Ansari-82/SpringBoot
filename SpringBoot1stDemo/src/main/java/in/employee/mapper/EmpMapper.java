package in.employee.mapper;

import in.employee.dto.ReqDto;
import in.employee.dto.RespDto;
import in.employee.entity.Employee;

public interface EmpMapper {

    RespDto entityToDto(Employee emp);
    Employee dtoToEntity(ReqDto dto);

}
