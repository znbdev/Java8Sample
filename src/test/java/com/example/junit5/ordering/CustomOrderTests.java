package com.example.junit5.ordering;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(DeprecatedInEndTestOrder.class)
class CustomOrderTests {
	@Test
	@Deprecated
	void testC() {
		assertTrue(true);
	}

	@Test
	void testA() {
		assertTrue(true);
	}

	@Test
	void testD() {
		assertTrue(true);
	}
	@Deprecated
	@Test
	void testE() {
		assertTrue(true);
	}

	@Test
	void testB() {
		assertTrue(true);
	}
}
