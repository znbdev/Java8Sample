package com.example.junit5.ordering;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

import java.util.Comparator;

public class DeprecatedInEndTestOrder implements MethodOrderer {

	private Comparator<MethodDescriptor> comparator = Comparator
				.comparing(md -> md.getMethod().isAnnotationPresent(Deprecated.class));

	@Override
	public void orderMethods(MethodOrdererContext context) {

		context.getMethodDescriptors().sort(comparator);
	}
}
