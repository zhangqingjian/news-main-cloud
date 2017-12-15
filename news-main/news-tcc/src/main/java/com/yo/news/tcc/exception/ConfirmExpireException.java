package com.yo.news.tcc.exception;

/**
 */
public class ConfirmExpireException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5871376470318346557L;

	public ConfirmExpireException(String message)
	{
		super(message);
	}

	public ConfirmExpireException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ConfirmExpireException(Throwable cause)
	{
		super(cause);
	}

	protected ConfirmExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
