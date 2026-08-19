package in.employee.exception;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationExceptionRespDto {

	private Integer status;
	private LocalDateTime timeStamp;
	private String error;
	private String message;
	private String path;
	private Map<String, String>  fieldErrors;
	
	
}
