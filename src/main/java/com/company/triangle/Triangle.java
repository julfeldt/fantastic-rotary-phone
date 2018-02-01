package com.company.triangle;

/**
 * Represents a triangle, and can be used to determine the type.
 */
public class Triangle {

	// The three side lengths of the triangle
	private double a, b, c;

	/**
	 * Constructs a new triangle given the length of the 3 sides.
	 * 
	 * @param a the length of the first side
	 * @param b the length of the second side
	 * @param c the length of the third side
	 */
	public Triangle(double a, double b, double c) {
		validateTriangle(a, b, c);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Determines the type of the triangle based on its sides.
	 * 
	 * @return the triangle type
	 */
	public TriangleType determineType() {
		TriangleType type = null;
		if (isEquilateral()) {
			type = TriangleType.EQUILATERAL;
		} else if (isIsosceles()) {
			type = TriangleType.ISOSCELES;
		} else {
			type = TriangleType.SCALENE;
		}
		return type;
	}

	/**
	 * Validates that the 3 sides can form a valid triangle. Raises an
	 * {@link IllegalArgumentException} if the triangle is invalid.
	 * 
	 * @param a the length of the first side
	 * @param b the length of the second side
	 * @param c the length of the third side
	 */
	private void validateTriangle(double a, double b, double c) {
		validateSideLength(a);
		validateSideLength(b);
		validateSideLength(c);

		// Test if the three sides of the triangle can form a triangle.
		boolean triangleInequalityTeorem = a + b > c && a + c > b && b + c > a;
		if (!triangleInequalityTeorem) {
			throw new IllegalArgumentException("The 3 side lengths do not form a valid triangle");
		}
	}

	/**
	 * Validates the length of a given side. Raises an
	 * {@link IllegalArgumentException} if the side length is invalid.
	 * 
	 * @param length the length of the side
	 */
	private void validateSideLength(double length) {
		if (length <= 0) {
			throw new IllegalArgumentException("The side length " + length + " must be a positive number");
		}
	}

	/**
	 * @return <code>true</code> if the triangle is equilateral.
	 */
	private boolean isEquilateral() {
		return a == b && b == c;
	}

	/**
	 * @return <code>true</code> if the triangle is isosceles.
	 */
	private boolean isIsosceles() {
		return b == c || a == b || c == a;
	}

}
