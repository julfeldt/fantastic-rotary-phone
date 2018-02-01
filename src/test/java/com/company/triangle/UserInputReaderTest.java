package com.company.triangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.company.triangle.reader.UserInputReader;

/**
 * Test of the {@link UserInputReader} class.
 */
public class UserInputReaderTest {

	// Class under test
	private UserInputReader cut = null;

	@Test(expected = IllegalArgumentException.class)
	public void newUserInputReader_noInputStream_exception() {
		cut = new UserInputReader(null);
	}

	@Test
	public void readSides_validInput_sides() {
		cut = new UserInputReader(prepareInputStreamWithData(4, 4, 4));

		double[] sides = cut.readSideLengths();

		assertNotNull(sides);
		assertArrayEquals(new double[] { 4, 4, 4 }, sides, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideA_exception() {
		cut = new UserInputReader(prepareInputStreamWithData("a", 4, 4));

		cut.readSideLengths();
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideB_exception() {
		cut = new UserInputReader(prepareInputStreamWithData(4, "a", 4));

		cut.readSideLengths();
	}

	@Test(expected = IllegalArgumentException.class)
	public void readSides_notANumberSideC_exception() {
		cut = new UserInputReader(prepareInputStreamWithData(4, 4, "a"));

		cut.readSideLengths();
	}

	// Helpers

	private String simulateInput(Object... sides) {
		String input = "";
		for (Object s : sides) {
			input += s + "\n";
		}
		return input;
	}

	private InputStream prepareInputStreamWithData(Object... sides) {
		InputStream is;
		String input = simulateInput(sides);
		try {
			is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			// convert to unchecked exception
			throw new RuntimeException("unsupported charset", e);
		}
		return is;
	}

}
