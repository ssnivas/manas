package com.math.fibonacci;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class FibonacciResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(FibonacciResource.class);
	}

	@Test
	public void testGetFebonacci() {
		String resp = target(FibonacciResource.PATH).path("/10").request()
				.get(String.class);
		assertEquals("\"0 1 1 2 3 5 8 13 21 34\"", resp);
	}

}
