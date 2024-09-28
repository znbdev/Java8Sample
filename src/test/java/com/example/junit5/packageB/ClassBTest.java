package com.example.junit5.packageB;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassBTest
{
	@Tag("development")
	@Test
	@DisplayName("testCaseB inside ClassBTest inside packageB")
	void testCaseB() {
		
	}
}
