package com.easykart.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class CFCoreException.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EasyKartException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4265643737002567524L;

	private HttpStatus httpStatus;

	private Integer code;

	public EasyKartException(String message) {
		super(message);
	}

	public EasyKartException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public EasyKartException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

}
