package in.employee.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ErrorPage {

	private Integer status;
	private LocalDateTime timeStamp;
	private String message;
	private String error;
	private String path;

}
