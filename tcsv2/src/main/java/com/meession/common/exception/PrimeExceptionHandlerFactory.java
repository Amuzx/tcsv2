package com.meession.common.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * @author sam
 */
public class PrimeExceptionHandlerFactory extends ExceptionHandlerFactory {

	private final ExceptionHandlerFactory wrapped;

	public PrimeExceptionHandlerFactory(final ExceptionHandlerFactory wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new PrimeExceptionHandler(wrapped.getExceptionHandler());
	}

	@Override
	public ExceptionHandlerFactory getWrapped() {
		return wrapped;
	}
}
