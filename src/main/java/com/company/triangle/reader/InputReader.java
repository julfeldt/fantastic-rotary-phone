package com.company.triangle.reader;

/**
 * Interface for reading input
 */
public interface InputReader {

	/**
	 * Reads the side lengths of the triangle from some input source specified by
	 * the implementation.
	 * 
	 * @return an array of the triangle's side lengths
	 */
	double[] readSideLengths();

}
