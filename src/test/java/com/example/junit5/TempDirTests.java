package com.example.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TempDirTests {
	
	@TempDir(cleanup = CleanupMode.DEFAULT)
	Path tempDir;

	@Test
	void tempDirectoryTestOne() throws IOException {
		Path tempFile = tempDir.resolve("test.txt");

		List<String> lines = Arrays.asList("howtodoinjava.com");

		Files.write(tempFile, Arrays.asList("howtodoinjava.com"));

		Assertions.assertTrue(Files.exists(tempFile), "Temp File should have been created");
		Assertions.assertEquals(Files.readAllLines(tempFile), lines);
	}
	
	@BeforeEach
	public void setup(@TempDir Path tempDir) throws IOException {
		Path tempFile = tempDir.resolve("test.txt");
		Files.write(tempFile, Arrays.asList("some content"));
	}
}
