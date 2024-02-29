package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
				0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}

	@Test
	public void combineSucceedsWhenBothRangesAreIdentical() {
		Range testRange1 = new Range(-5, 5);
		Range testRange2 = new Range(-5, 5);
		
		Range result = Range.combine(testRange1, testRange2);
		
		assertEquals("The range should be between -5 and 5", 
				new Range(-5, 5), result);
	}
	
	@Test
	public void combineSucceedsWithTwoRangesThatDoNotOverlap() {
		Range testRange1 = new Range(-1, 1);
		Range testRange2 = new Range(5, 10);
		
		Range result = Range.combine(testRange2, testRange1);
		
		assertEquals("The range should be between -1 and 10",
				new Range(-1, 10), result);
	}
	
	@Test
	public void combineSucceedsWithTwoRangesThatOverlap() {
		Range testRange1 = new Range(-1, 5);
		Range testRange2 = new Range(2, 6);
		
		Range result = Range.combine(testRange2, testRange1);
		
		assertEquals("The range should be between -1 and 6",
				new Range(-1, 6), result);
	}
	
	@Test
	public void combineSucceedsWhenRange1IsNull() {
		Range testRange1 = null;
		Range testRange2 = new Range(3, 10);
		
		Range result = Range.combine(testRange2, testRange1);
		
		assertEquals("The range should be between 3 and 10",
				new Range(3, 10), result);
	}
	
	@Test
	public void combineSucceedsWhenRange2IsNull() {
		Range testRange1 = new Range(3, 10);
		Range testRange2 = null;
		
		Range result = Range.combine(testRange2, testRange1);
		
		assertEquals("The range should be between 3 and 10",
				new Range(3, 10), result);
	}
	
	@Test
	public void combineGivesNullWhenBothRangesAreNull() {
		Range testRange1 = null;
		Range testRange2 = null;
		
		Range result = Range.combine(testRange2, testRange1);
		
		assertNull("The range should be null", result);
	}
	
	@Test
	public void constrainSucceedsWhenValueExistsInRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertEquals("The constrained value should be 2",
				2.0, testRange1.constrain(2.0), 0.000000001d);
	}
	
	@Test
	public void constrainSucceedsWhenValueAboveRangeMustBeRoundedDown() {
		Range testRange1 = new Range(-5, 5);
		
		assertEquals("The constrained value should be 6",
				5.0, testRange1.constrain(6.0), 0.000000001d);
	}
	
	@Test
	public void constrainSucceedsWhenValueBelowRangeMustBeRoundedUp() {
		Range testRange1 = new Range(-5, 5);
		
		assertEquals("The constrained value should be -5",
				-5.0, testRange1.constrain(-6.0), 0.000000001d);
	}
	
	@Test
	public void constrainSucceedsWhenValueIsOnUpperEdgeOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertEquals("The constrained value should be 5",
				5.0, testRange1.constrain(5.0), 0.000000001d);
	}
	
	@Test
	public void constrainSucceedsWhenValueIsOnLowerEdgeOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertEquals("The constrained value should be -5",
				-5.0, testRange1.constrain(-5.0), 0.000000001d);
	}
	
	@Test
	public void containsIsTrueWhenValueIsWithinRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The double value 2.0 should be present within Range",
				testRange1.contains(2.0));
	}
	
	@Test
	public void containsIsTrueWhenValueIsOnLowerEdgeOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The double value -5.0 should be present within Range",
				testRange1.contains(-5.0));
	}
	
	@Test
	public void containsIsTrueWhenValueIsOnUpperEndOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The double value 5.0 should be present within Range",
				testRange1.contains(5.0));
	}
	
	@Test
	public void containsIsFalseWhenValueIsLowerThanRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertFalse("The double value -6 should not be present within Range",
				testRange1.contains(-6.0));
		
	}
	
	@Test
	public void containsIsFalseWhenValueIsHigherThanRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertFalse("The double value 6 should not be present within Range",
				testRange1.contains(6.0));
	}
	
	@Test
	public void expandToIncludeSucceedsWhenValueIsWithinRange() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, 1);
		
		assertEquals("The new range should be between -5 and 5",
				new Range(-5, 5), testRange1);
	}
	
	@Test
	public void expandToIncludeSucceedsWhenValueIsAboveRange() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, 10);
		
		assertEquals("The new range should be between -5 and 10",
				new Range(-5, 10), testRange1);
	}
	
	@Test
	public void expandToIncludeSucceedsWhenValueIsBelowRange() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, -10);
		
		assertEquals("The new range should be between -10 and 5",
				new Range(-10, 5), testRange1);
	}
	
	@Test
	public void expandToIncludeSucceedsWhenExpandingLowerAndUpperEdges() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, 10);
		Range.expandToInclude(testRange1, -10);
		
		assertEquals("The new range should be between -10 and 10",
				new Range(-10, 10), testRange1);
	}
	
	@Test
	public void expandToIncludeSucceedsWhenExpandingUpperEdgeTwice() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, 10);
		Range.expandToInclude(testRange1, 20);
		
		assertEquals("The new range should be between -5 and 20",
				new Range(-5, 20), testRange1);
	}
	
	@Test
	public void expandToIncludeSucceedsWhenExpandingLowerEdgeTwice() {
		Range testRange1 = new Range(-5, 5);
		Range.expandToInclude(testRange1, -10);
		Range.expandToInclude(testRange1, -20);
		
		assertEquals("The new range should be between -20 and 5",
				new Range(-20, 5), testRange1);
	}
	
	@Test
	public void intersectsSucceedsWhenOnlyUpperValueIsInRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of -10 to 2 intersects with our test range",
				testRange1.intersects(-10, 2));
	}
	
	@Test
	public void intersectsSucceedsWhenOnlyLowerValueIsInRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of -2 to 10 intersects with our test range",
				testRange1.intersects(2, 10));
	}
	
	@Test
	public void intersectsSucceedsWhenBothUpperAndLowerValueAreWithinRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of -2 to 4 intersects with our test range",
				testRange1.intersects(2, 4));
	}
	
	@Test
	public void intersectsSucceedsWhenUpperValueIsAboveRangeAndLowerIsBelow() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of -10 to 10 intersects with our test range",
				testRange1.intersects(-10, 10));
	}
	
	@Test
	public void intersectsFailsWhenBothUpperAndLowerAreBelowRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertFalse("The range of -15 to -10 does not intersect with our test range",
				testRange1.intersects(-15, -10));
	}
	
	@Test
	public void intersectsFailsWhenBothUpperAndLowerAreAboveRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertFalse("The range of 10 to 15 does not intersect with our test range",
				testRange1.intersects(10, 15));
	}
	
	@Test
	public void intersectsSucceedsWhenUpperValueIsOnEdgeOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of -10 to -5 intersects with our test range",
				testRange1.intersects(-10, -5));
	}
	
	@Test
	public void intersectsSucceedsWhenLowerValueIsOnEdgeOfRange() {
		Range testRange1 = new Range(-5, 5);
		
		assertTrue("The range of 5 to 10 intersects with our test range",
				testRange1.intersects(5, 10));
	}
}
