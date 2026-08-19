package in.employee.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RespDto {

    private Integer id;
    private String name;
    private String address;
    private String email;
    private String mobile; 
    private Double salary;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;
}
