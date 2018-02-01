package com.company.triangle;

import com.company.triangle.reader.CommandLineInputReader;
import com.company.triangle.reader.InputReader;
import com.company.triangle.reader.UserInputReader;

/**
 * This class is the entry point for the application.
 */
public class Main {

	public static void main(String[] args) {
		try {
			InputReader inputReader = getInputReader(args);
			Triangle triangle = buildTriangle(inputReader);
			System.out.printf("It is a %s triangle%n", triangle.determineType());
		} catch (Exception e) {
			String error = e.getMessage();
			if (error == null || error.equals("")) {
				error = "Uknown error determining the type of triangle";
			}
			System.err.println(error);
		}
	}

	/**
	 * Determines and returns which {@link InputReader} implementation to use for
	 * accepting input. If call arguments are specified, it will use a
	 * {@link CommandLineInputReader} and otherwise the {@link UserInputReader}
	 * implementation is used.
	 * 
	 * @param args the application call parameters
	 * @return the {@link InputReader} implementation to use
	 */
	static InputReader getInputReader(String[] args) {
		InputReader inputReader = null;
		if (args != null && args.length > 0) {
			inputReader = new CommandLineInputReader(args);
		} else {
			inputReader = new UserInputReader(System.in);
		}
		return inputReader;
	}

	/**
	 * Builds the triangle based on specified side lengths.
	 * 
	 * @param inputReader the implementation used to read input
	 * @return a new {@link Triangle} instance
	 */
	static Triangle buildTriangle(InputReader inputReader) {
		if (inputReader == null) {
			throw new IllegalArgumentException("InputReader cannot be null");
		}
		double[] sides = inputReader.readSideLengths();
		return new Triangle(sides[0], sides[1], sides[2]);
	}
}
