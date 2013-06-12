/**
 * Copyright (c) 2012 Virtual Vehicle (ViF).
 * www.v2c2.at
 *
 * Created at:
 *  11.07.2012
 * 
 * Authors:
 *  @author stefanpaschke
 *
 */
package olsc.consumer;

import java.io.Serializable;

/**
 * Exception used to indicate errors caused by using package consumer.
 * 
 * @author stefanpaschke
 * 
 */
public class ConsumerException
		extends
			Exception
		implements
			Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ConsumerException()
	{
		super();		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConsumerException(String message, Throwable cause)
	{
		super(message);
		this.setStackTrace(cause.getStackTrace());
	}

	/**
	 * @param message
	 */
	public ConsumerException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConsumerException(final Throwable cause)
	{
		super(cause.getClass().getSimpleName() + ": " + cause.getMessage());
		this.setStackTrace(cause.getStackTrace());
	}
}
