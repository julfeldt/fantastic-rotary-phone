package com.company.triangle.reader;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class is responsible for prompting user for input.
 */
public class UserInputReader implements InputReader {

	private InputStream is = null;

	/**
	 * Construct a new instance with a specified {@link InputStream}.
	 * 
	 * @param is the {@link InputStream} to take user input from
	 */
	public UserInputReader(InputStream is) {
		if (is == null) {
			throw new IllegalArgumentException("Inputstream cannot be null");
		}
		this.is = is;
	}

	/**
	 * Reads the side lengths of a triangle from the given input stream.
	 * 
	 * @param is the stream to read the input from
	 * @return array of the triangle side lengths
	 */
	@Override
	public double[] readSideLengths() {
		double[] sides = null;
		try (Scanner sn = new Scanner(is)) {
			System.out.println("Input side length a: ");
			double a = sn.nextDouble();
			System.out.println("Input side length b: ");
			double b = sn.nextDouble();
			System.out.println("Input side length c: ");
			double c = sn.nextDouble();

			sides = new double[] { a, b, c };
		} catch (Exception e) {
			throw new IllegalArgumentException("Input error. Not a valid side length", e);
		}
		return sides;
	}

}
