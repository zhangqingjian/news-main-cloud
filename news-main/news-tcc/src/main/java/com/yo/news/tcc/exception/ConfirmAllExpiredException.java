package com.yo.news.tcc.exception;

/**
 */
public class ConfirmAllExpiredException extends RuntimeException
{

	private static final long serialVersionUID = 2336784357948344886L;

	public ConfirmAllExpiredException(String message)
	{
		super(message);
	}

	public ConfirmAllExpiredException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ConfirmAllExpiredException(Throwable cause)
	{
		super(cause);
	}

	protected ConfirmAllExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
