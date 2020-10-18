package com.wolox.socialnetwork.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wolox.socialnetwork.exceptions.JsonPlaceHolderServiceException;
import com.wolox.socialnetwork.exceptions.ObjectNotFoundException;
import com.wolox.socialnetwork.exceptions.ResponseServiceException;
import com.wolox.socialnetwork.exceptions.handler.model.GenericError;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SocialNetworkExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Value("${JsonPlaceHolderServiceException.code}")
	private String jsonPlaceHolderServiceCode;

	@Value("${JsonPlaceHolderServiceException.message}")
	private String jsonPlaceHolderServiceMessage;

	@Value("${ResponseServiceException.code}")
	private String responseServiceCode;

	@Value("${ResponseServiceException.message}")
	private String responseServiceMessage;

	@Value("${ObjectNotFoundException.code}")
	private String objectNotFoundCode;

	@Value("${ObjectNotFoundException.message}")
	private String objectNotFoundMessage;

	@ExceptionHandler(JsonPlaceHolderServiceException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	protected GenericError JsonPlaceHolderServiceExceptionHandler(JsonPlaceHolderServiceException ex) {

		String code = jsonPlaceHolderServiceCode;
		String message = new StringBuilder(jsonPlaceHolderServiceMessage).append(" [").append(ex.getServiceMethod())
				.append("]").toString();

		GenericError error = new GenericError(code, message);

		logger.error("An error occurred while trying to consume JsonPlaceHolder Service.");

		return error;
	}

	@ExceptionHandler(ResponseServiceException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	protected GenericError ResponseServiceExceptionHandler(ResponseServiceException ex) {

		String code = new StringBuilder(responseServiceCode).append(ex.getErrorCode()).toString();
		String message = responseServiceMessage;

		GenericError error = new GenericError(code, message);

		logger.error("An error occurred while trying to consume JsonPlaceHolder Service.");

		return error;
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	protected GenericError ObjectNotFoundExceptionHandler(ObjectNotFoundException ex) {

		String message = new StringBuilder(objectNotFoundMessage).append(" (").append(ex.getErrorMessage()).append(")")
				.toString();

		GenericError error = new GenericError(objectNotFoundCode, message);
		logger.error("An error occurred while trying to get an object from the database or external API");
		return error;
	}

}
