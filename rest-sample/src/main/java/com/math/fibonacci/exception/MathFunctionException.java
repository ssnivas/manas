package com.math.fibonacci.exception;

import javax.ws.rs.core.Response.StatusType;

public class MathFunctionException extends Exception {

	private static final long serialVersionUID = -5280458746090301770L;

	private int errorId;
	private StatusType statusCode;

	public MathFunctionException() {
		super();
	}

	public MathFunctionException(int errorId, String message,
			StatusType statusCode) {
		super(message);
		this.errorId = errorId;
		this.statusCode = statusCode;
	}

	public MathFunctionException(String message, Throwable cause,
			StatusType statusCode) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public int getErrorId() {
		return this.errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public StatusType getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(StatusType statusCode) {
		this.statusCode = statusCode;
	}

}
