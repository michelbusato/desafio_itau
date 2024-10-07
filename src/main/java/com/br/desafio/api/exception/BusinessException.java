package com.br.desafio.api.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Integer errorCode;

	public final String errorMessage;
	
	public BusinessException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
