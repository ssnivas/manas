package com.math.fibonacci.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MathFunctionExceptionMapper implements
		ExceptionMapper<MathFunctionException> {

	@Override
	public Response toResponse(MathFunctionException mathFunException) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(mathFunException.getErrorId());
		errorDetails.setErrorMessage(mathFunException.getMessage());
		return Response.status(mathFunException.getStatusCode())
				.entity(errorDetails).type(MediaType.APPLICATION_JSON).build();
	}

}
