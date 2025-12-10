package com.swagger.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceException extends Exception{

	private static final long serialVersionUID = 1L;
	private final String errorMsg;
	private final String errorCode;
}
