package com.math.fibonacci;

import java.util.regex.Pattern;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.math.fibonacci.exception.MathFunctionException;

/**
 * Root resource (exposed at "fibonacci" path)
 */
@Path(FibonacciResource.PATH)
public class FibonacciResource {

	public static final String PATH = "/fibonacci1";
	private static Pattern pattern = Pattern.compile(".*[^0-9].*");

	@GET
	@Path("/{termnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFebonacci(@PathParam("termnumber") String termNumber)
			throws MathFunctionException {
		if (pattern.matcher(termNumber.trim()).matches()) {
			throw new MathFunctionException(400,
					"allows only pasitive numbers", Response.Status.BAD_REQUEST);
		}
		int inputVal = Integer.valueOf(termNumber.trim()).intValue();
		String fibonacci = getFibonacciNumber(inputVal);
		return Response.ok("\"" + fibonacci + "\"").build();
	}

	private String getFibonacciNumber(int nVal) throws MathFunctionException {
		long first = 0l, second = 1l, third = 0l;
		StringBuilder output = new StringBuilder("");
		for (int inthVal = 0; inthVal < nVal; inthVal++) {
			if (inthVal < 2) {
				output.append(inthVal + " ");
			} else {
				third = first + second;
				if (third >> 63 != 0) {
					throw new MathFunctionException(400,
							"outbound value reached to " + (inthVal + 1)
									+ ", please enter below " + (inthVal + 1)
									+ " to get Fibonacci sequence",
							Response.Status.BAD_REQUEST);
				}
				output.append(third + " ");
				first = second;
				second = third;
			}
		}
		return output.toString().trim();
	}

}
