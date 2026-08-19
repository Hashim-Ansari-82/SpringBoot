package in.employee.service;

import in.employee.dto.ReqDto;
import in.employee.dto.RespDto;

import java.util.List;

public interface EmpService {

    RespDto save(ReqDto dto);
    List<RespDto> getAll();
    RespDto getById(Integer id);
    void delete(Integer id);
    RespDto update(Integer id,ReqDto dto);
    void softDelete(Integer id);
    boolean existsByEmail(ReqDto dto);
    RespDto restore(Integer id);
}
