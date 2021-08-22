package com.myaccount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncomeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncomeNotFoundException(String exception) {
		super(exception);
	}

}