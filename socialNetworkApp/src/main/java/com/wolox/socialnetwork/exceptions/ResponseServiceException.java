package com.wolox.socialnetwork.exceptions;

public class ResponseServiceException extends RuntimeException {

	private static final long serialVersionUID = 4472618546381221868L;
	private String errorMessage;
	private int errorCode;

	public ResponseServiceException() {
	}

	public ResponseServiceException(int errorCode, String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}