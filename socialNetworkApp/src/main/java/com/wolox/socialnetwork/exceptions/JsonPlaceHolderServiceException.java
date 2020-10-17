package com.wolox.socialnetwork.exceptions;

public class JsonPlaceHolderServiceException extends RuntimeException {

	private static final long serialVersionUID = -9090379577606600324L;
	private String errorMessage;
	private String errorCode;
	private String serviceMethod;

	public JsonPlaceHolderServiceException() {
	}

	public JsonPlaceHolderServiceException(String errorCode, String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public JsonPlaceHolderServiceException(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	} 

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}
	
	

}