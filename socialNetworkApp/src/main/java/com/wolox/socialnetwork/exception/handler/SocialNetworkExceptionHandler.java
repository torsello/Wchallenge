package com.wolox.socialnetwork.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wolox.socialnetwork.exception.JsonPlaceHolderServiceException;
import com.wolox.socialnetwork.exception.ResponseServiceException;
import com.wolox.socialnetwork.exception.handler.model.GenericError;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SocialNetworkExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@ExceptionHandler(JsonPlaceHolderServiceException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	protected GenericError JsonPlaceHolderServiceExceptionHandler(JsonPlaceHolderServiceException ex) {

		String code = "error.wolox.socialnetwork.json_place_holder.response";
		String message = new StringBuilder("Error fetching data from ").append("[").append(ex.getServiceMethod())
				.append("]").toString();

		GenericError error = new GenericError(code, message);

		logger.error("An error occurred while trying to consume JsonPlaceHolder Service.");

		return error;
	}
	
	@ExceptionHandler(ResponseServiceException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	protected GenericError ResponseServiceExceptionHandler(ResponseServiceException ex) {

		String code = new StringBuilder("error.wolox.socialnetwork.json_place_holder.response.code.").append(ex.getErrorCode()).toString();
		String message = ex.getErrorMessage();

		GenericError error = new GenericError(code, message);

		logger.error("An error occurred while trying to consume JsonPlaceHolder Service.");

		return error;
	}
	
}
