package com.sidda.library.util;

import java.util.UUID;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class Utils {
	private static final TimeBasedGenerator generator = Generators.timeBasedGenerator();

	public static UUID newID() {
		return generator.generate();
	}

	public static String newIDString() {
		return newID().toString();
	}
}
