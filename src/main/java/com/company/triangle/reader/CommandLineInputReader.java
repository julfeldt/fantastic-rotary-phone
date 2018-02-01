package com.company.triangle.reader;

/**
 * Class is responsible for reading input from the command-line call arguments.
 */
public class CommandLineInputReader implements InputReader {

	private String[] args;

	/**
	 * Construct a new instance with call parameters.
	 * 
	 * @param is the call application parameters
	 */
	public CommandLineInputReader(String[] args) {
		if (args == null || args.length != 3) {
			throw new IllegalArgumentException("Application requires 3 arguments");
		}
		this.args = args;
	}

	@Override
	public double[] readSideLengths() {
		return new double[] { getArg(0), getArg(1), getArg(2) };
	}

	/**
	 * Returns the call argument at the specified position as a double.
	 * 
	 * @param pos the position in the call argument array
	 * @return the argument as double
	 */
	private double getArg(int pos) {
		String arg = args[pos];
		double value = 0;
		try {
			value = Double.parseDouble(arg);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Argument '" + arg + "' is not a valid side length", nfe);
		}
		return value;
	}

}
