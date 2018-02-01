package com.company.triangle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.company.triangle.Main;
import com.company.triangle.Triangle;
import com.company.triangle.reader.CommandLineInputReader;
import com.company.triangle.reader.InputReader;
import com.company.triangle.reader.UserInputReader;

/**
 * Test of the {@link Main} class.
 */
public class MainTest {

	@Test(expected = IllegalArgumentException.class)
	public void buildTriangle_noInputReader_exception() {
		Main.buildTriangle(null);
	}

	@Test
	public void buildTriangle_validInput_triangle() {
		Triangle triangle = Main.buildTriangle(new DummyInputReader(5, 7, 10));

		assertNotNull(triangle);
	}

	@Test(expected = IllegalArgumentException.class)
	public void buildTriangle_invalidInput_exception() {
		Main.buildTriangle(new DummyInputReader(5, 5, 10));
	}

	@Test
	public void getInputReader_nullCallArguments_userInputReader() {
		InputReader inputReader = Main.getInputReader(null);

		assertTrue(inputReader instanceof UserInputReader);
	}

	@Test
	public void getInputReader_withCallArguments_CommandLineInputReader() {
		String[] args = new String[] { "5", "5", "5" };
		InputReader inputReader = Main.getInputReader(args);

		assertTrue(inputReader instanceof CommandLineInputReader);
	}

	/**
	 * Dummy implementation used to easily fake user input for the tests.
	 */
	private class DummyInputReader implements InputReader {

		private double a, b, c;

		public DummyInputReader(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public double[] readSideLengths() {
			return new double[] { a, b, c };
		}

	}

}
