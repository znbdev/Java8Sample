package com.example.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("development")
class ClassATest
{
	@Test
	@Tag("userManagement")
	void testCaseA(TestInfo testInfo) {
	}
}
