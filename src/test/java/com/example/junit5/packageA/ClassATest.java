package com.example.junit5.packageA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassATest
{
	@Tag("production")
	@Test
	@DisplayName("testCaseA inside ClassATest inside packageA")
	void testCaseA() {
		
	}
}
