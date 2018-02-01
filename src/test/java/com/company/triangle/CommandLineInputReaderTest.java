package com.company.triangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.company.triangle.reader.CommandLineInputReader;

/**
 * Test of the {@link CommandLineInputReader} class.
 */
public class CommandLineInputReaderTest {

	// Class under test
	private CommandLineInputReader cut;
	private String[] args;

	@Test(expected = IllegalArgumentException.class)
	public void newCommandLineInputReader_noCallArguments_exception() {
		cut = new CommandLineInputReader(null);
	}

	@Test
	public void readSides_validInput_sides() {
		args = new String[] { "5", "5", "5" };
		cut = new CommandLineInputReader(args);

		double[] sides = cut.readSideLengths();

		assertNotNull(sides);
		assertArrayEquals(new double[] { 5, 5, 5 }, sides, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideA_exception() {
		args = new String[] { "a", "5", "5" };
		cut = new CommandLineInputReader(args);

		cut.readSideLengths();
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideB_exception() {
		args = new String[] { "5", "a", "5" };

		cut = new CommandLineInputReader(args);

		cut.readSideLengths();
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideC_exception() {
		args = new String[] { "5", "5", "c" };
		cut = new CommandLineInputReader(args);

		cut.readSideLengths();
	}

}
