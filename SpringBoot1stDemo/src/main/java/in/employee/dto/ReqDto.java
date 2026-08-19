package in.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReqDto {

    @NotBlank(message = "Name must be enter")
    private String name;
    @NotBlank(message = "Enter Emp Address")
    private String address;
    @Email
    private String email;
    @NotBlank(message = "Enter Emp mobile")
    private String mobile;
    @NotNull(message = "Enter Emp salary")
    private Double salary;
    @NotBlank(message = "Enter Emp department")
    private String department;
}
