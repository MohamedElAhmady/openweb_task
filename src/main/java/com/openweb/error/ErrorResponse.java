package com.openweb.error;

import lombok.Data;

/*Error class it contains the error message and error code*/
@Data
public class ErrorResponse {
	private int errorCode;
	private String message;

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
