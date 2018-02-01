package com.company.triangle;

/**
 * The supported triangles types.
 */
public enum TriangleType {

	ISOSCELES("isosceles"),

	EQUILATERAL("equilateral"),

	SCALENE("scalene");

	private String type;

	private TriangleType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}
