package com.company.triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test of the {@link Triangle} class.
 */
import org.junit.Test;

import com.company.triangle.Triangle;
import com.company.triangle.TriangleType;

/**
 * Test of the {@link Triangle} class.
 */
public class TriangleTest {

	// Class under test
	private Triangle cut = null;

	@Test
	public void newTriangle_validSides_validTriangle() {
		cut = new Triangle(5, 7, 10);

		assertNotNull(cut);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_negativeSideA_exception() {
		cut = new Triangle(-5, 7, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_negativeSideB_exception() {
		cut = new Triangle(5, -7, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_negativeSideC_exception() {
		cut = new Triangle(5, 7, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_zeroeSideA_exception() {
		cut = new Triangle(0, 7, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_zeroSideB_exception() {
		cut = new Triangle(5, 0, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_zeroSideC_exception() {
		cut = new Triangle(5, 7, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_impossibleSidesCombination_exception() {
		cut = new Triangle(5, 8, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_impossibleSidesCombination2_exception() {
		cut = new Triangle(5, 3, 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void newTriangle_impossibleSidesCombination3_exception() {
		cut = new Triangle(8, 3, 5);
	}

	@Test
	public void newTriangle_allEqualSides_isEquilateral() {
		cut = new Triangle(5, 5, 5);

		assertEquals(TriangleType.EQUILATERAL, cut.determineType());
	}

	@Test
	public void newTriangle_onlyTwoEqualSides_isIsosceles() {
		cut = new Triangle(5, 5, 4);

		assertEquals(TriangleType.ISOSCELES, cut.determineType());
	}

	@Test
	public void newTriangle_onlyTwoEqualSides2_isIsosceles() {
		cut = new Triangle(4, 5, 5);

		assertEquals(TriangleType.ISOSCELES, cut.determineType());
	}

	@Test
	public void newTriangle_onlyTwoEqualSides3_isIsosceles() {
		cut = new Triangle(5, 4, 5);

		assertEquals(TriangleType.ISOSCELES, cut.determineType());
	}

	@Test
	public void newTriangle_noEqualSides_isScalene() {
		cut = new Triangle(5, 7, 10);

		assertEquals(TriangleType.SCALENE, cut.determineType());
	}

}
