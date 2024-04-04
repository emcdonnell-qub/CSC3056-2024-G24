package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	private Values2D values2D;
	private Values2D rowValues2D;
	private Values2D colCoverageValues2D;
	private Values2D rowCoverageValues2D;
	private double[] arrayData;
	private double[][] arrayData2D;
	private KeyedValues keyedValues;
	private KeyedValues emptyKeyedValues;
	private KeyedValues negKeyedValues;
	private KeyedValues perTotalKeyedValues;
	private KeyedValues perRunningTotalKeyedValues;

	// calculateColumnTotal Method
	// LAB 3
	@Before
	public void setUpCoverageNullDataColumnTotal() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		colCoverageValues2D = testValues;
		testValues.addValue(1, 0, 0);   
		testValues.addValue(3, 0, 1);    
		testValues.addValue(7, 0, 2);
		testValues.addValue(null, 0, 3);
		    
		testValues.addValue(9, 1, 0);
		testValues.addValue(-66, 1, 1); 
		testValues.addValue(12, 1, 2);   
		testValues.addValue(null, 1, 3); 
	}
	@After
	public void tearDownCoverageNullDataColumnTotal() throws Exception {
		colCoverageValues2D = null;
	}
	@Test
	public void testCoverageNullDataColumnTotal() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateColumnTotal(colCoverageValues2D, 3), 0.0000001d);
	}
	// LAB 2
	@Before
	public void setUpValidInvalidNullDataColumnTotal() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);   
		testValues.addValue(3, 0, 1);    
		testValues.addValue(7, 0, 2);
		testValues.addValue(18, 0, 3);
		    
		testValues.addValue(9, 1, 0);
		testValues.addValue(-66, 1, 1); 
		testValues.addValue(12, 1, 2);   
		testValues.addValue(-456, 1, 3); 
	}
	@After
	public void tearDownValidInvalidNullDataColumnTotal() throws Exception {
		values2D = null;
	}
	@Test
	public void testValidDataAndPositiveColumnTotal() {
		assertEquals("Wrong sum returned. It should be -438.0",
				-438.0, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
	}
	
	@Test
	public void testValidDataAndNegativeColumnTotal() {
		try
		{
			DataUtilities.calculateColumnTotal(values2D, -13);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IndexOutOfBounds Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class)); // IllegalArgumentException
		}
	}
	
	@Test
	public void testNullDataPositiveColumnTotal()
	{
		try
		{
			DataUtilities.calculateColumnTotal(null, 3);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: NullPointer Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class)); // IllegalArgumentException
		}
	}
	
	@Test
	public void testNullDataNegativeColumnTotal()
	{
		try
		{
			DataUtilities.calculateColumnTotal(null, -13);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: NullPointer Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class)); // IllegalArgumentException
		}
	}

	
	@Before
    public void setUpEmptyColumnData() throws Exception {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        values2D = testValues;
    }

    @After
    public void tearDownEmptyColumnData() throws Exception {
        values2D = null;
    }
    
	@Test
	public void testEmptyDataPositiveColumnTotal() //No Explanation on JavaDocs for empty data set so assuming outcome
	{
		try
		{
			DataUtilities.calculateColumnTotal(values2D, 3);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testEmptyDataNegativeColumnTotal() //No Explanation on JavaDocs for empty data set so assuming outcome
	{
		try
		{
			DataUtilities.calculateColumnTotal(values2D, -13);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IndexOutOfBounds Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class)); // IllegalArgumentException
		}
	}

	
	// calculateRowTotal Method
	// LAB 3
	@Before
	public void setUpCoverageNullDataRowTotal() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(1, 0, 0);   
        testValues.addValue(4, 0, 1);    
        testValues.addValue(9, 0, 2);

        testValues.addValue(15, 1, 0);
        testValues.addValue(16, 1, 1); 
        testValues.addValue(20, 1, 2);

        testValues.addValue(null, 2, 0);
        testValues.addValue(null, 2, 1); 
        testValues.addValue(null, 2, 2);

        rowCoverageValues2D = testValues; 
	}
	@After
	public void tearDownCoverageNullDataRowTotal() throws Exception {
		rowCoverageValues2D = null;
	}
	@Test
	public void testCoverageNullDataRowTotal() {
		assertEquals("Wrong sum returned. It should be 0.0",
				0.0, DataUtilities.calculateRowTotal(rowCoverageValues2D, 2), 0.0000001d);
	}
	// LAB 2
	@Before
    public void setUpValidInvalidNullDataRowTotal() throws Exception {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(1, 0, 0);   
        testValues.addValue(4, 0, 1);    
        testValues.addValue(9, 0, 2);

        testValues.addValue(15, 1, 0);
        testValues.addValue(16, 1, 1); 
        testValues.addValue(20, 1, 2);

        testValues.addValue(44, 2, 0);
        testValues.addValue(65, 2, 1); 
        testValues.addValue(79, 2, 2);

        rowValues2D = testValues;
    }
	
	@After
    public void tearDownValidInvalidNullRowTotal() throws Exception {
        rowValues2D = null;
    }
	
	@Test
	public void testValidDataAndPositiveRowTotal() {
		assertEquals("Wrong sum returned. It should be 51.0",
				51.0, DataUtilities.calculateRowTotal(rowValues2D, 1), 0.0000001d);
	}
	
	@Test
	public void testValidDataAndNegativeRowTotal() {
		try
		{
			DataUtilities.calculateRowTotal(rowValues2D, -4);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IndexOutOfBounds Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class)); // IllegalArgumentException
		}
	}
	
	@Test
	public void testNullDataPositiveRowTotal()
	{
		try
		{
			DataUtilities.calculateRowTotal(null, 3);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: NullPointer Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class)); // IllegalArgumentException
		}
	}
	
	@Test
	public void testNullDataNegativeRowTotal()
	{
		try
		{
			DataUtilities.calculateRowTotal(null, -13);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: NullPointer Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class)); // IllegalArgumentException
		}
	}
	
	@Before
    public void setUpEmptyRowData() throws Exception {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        rowValues2D = testValues;
    }

    @After
    public void tearDownEmptyRowData() throws Exception {
        rowValues2D = null;
    }
    
	@Test
	public void testEmptyDataPositiveRowTotal() //No Explanation on JavaDocs for empty data set so assuming outcome
	{
		try
		{
			DataUtilities.calculateRowTotal(rowValues2D, 3);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testEmptyDataNegativeRowTotal() //No Explanation on JavaDocs for empty data set so assuming outcome
	{
		try
		{
			DataUtilities.calculateRowTotal(rowValues2D, -13);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IndexOutOfBounds Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class)); // IllegalArgumentException
		}
	}
	
	
	// createNumberArray Method
	@Before
	public void setUpCreateNumberArray() throws Exception{
		arrayData = new double[]{1.9, 46.4, 2.6, -5.2};
	}
	
	@After
	public void tearDownCreateNumberArray() throws Exception {
		arrayData = null;
	}
	
	@Test
	public void testCreateNumberArray() {
		Number[] expected = {1.9, 46.4, 2.6, -5.2};
		assertArrayEquals("Incorrect array of Number objects", expected, DataUtilities.createNumberArray(arrayData));
	}
	
	@Test
	public void testNullNumberArray() {
		try
		{
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Before
	public void setUpEmptyNumberArray() throws Exception {
		arrayData = new double[]{};
	}
	
	@After
	public void tearDownEmptyNumberArray() throws Exception {
		arrayData = null;
	}
	
	@Test
	public void testEmptyNumberArray() {
		try
		{
			DataUtilities.createNumberArray(arrayData);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	// createNumberArray2D Method
	@Before
    public void setUpCreateNumberArray2D() throws Exception {
        arrayData2D = new double[][]{{1.9, 46.4, 2.6, -5.2}, {3.2, 3.8, 78.9}};
    }

    @After
    public void tearDownCreateNumberArray2D() throws Exception {
        arrayData2D = null;
    }
    
    @Test
    public void testCreateNumberArray2D() {
    	Number[][] expected = {{1.9, 46.4, 2.6, -5.2}, {3.2, 3.8, 78.9}};
        assertArrayEquals("Incorrect array of Number objects", expected, DataUtilities.createNumberArray2D(arrayData2D));
    }
    
    @Test
	public void testNullNumberArray2D() {
		try
		{
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Before
	public void setUpEmptyNumberArray2D() throws Exception {
		arrayData2D = new double[][]{};
	}
	
	@After
	public void tearDownEmptyNumberArray2D() throws Exception {
		arrayData2D = null;
	}
	
	@Test
	public void testEmptyNumberArray2D() {
		try
		{
			DataUtilities.createNumberArray2D(arrayData2D);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	// getCumulativePercentages Method
	// LAB 3
	@Before
	public void setUpCoverageNullTotalCumulativePercentage() throws Exception {
		DefaultKeyedValues perTest = new DefaultKeyedValues();
		perTotalKeyedValues = perTest;
        perTest.addValue("0", 5);
        perTest.addValue("1", 9);
        perTest.addValue("2", 2);
	}
	
	@After
	public void tearDownCoverageNullTotalCumulativePercentage() throws Exception {
		perTotalKeyedValues = null;
	}
	
	@Test
	public void testCoverageNullTotalCumulativePercentage() {
		KeyedValues result = DataUtilities.getCumulativePercentages(perTotalKeyedValues);
		assertEquals(0.3125, result.getValue("0").doubleValue(), 0.0000001d);
        assertEquals(0.0, result.getValue(null).doubleValue(), 0.0000001d);
        assertEquals(1.0, result.getValue("2").doubleValue(), 0.0000001d);
	}
	@Before
	public void setUpCoverageNullRunningTotalCumulativePercentage() throws Exception {
		DefaultKeyedValues perTest = new DefaultKeyedValues();
		perRunningTotalKeyedValues = perTest;
        perTest.addValue("0", 5);
        perTest.addValue("1", 9);
        perTest.addValue("2", null);
	}
	
	@After
	public void tearDownCoverageNullRunningTotalCumulativePercentage() throws Exception {
		perRunningTotalKeyedValues = null;
	}
	
	@Test
	public void testCoverageNullRunningTotalCumulativePercentage() {
		KeyedValues result = DataUtilities.getCumulativePercentages(perRunningTotalKeyedValues);
		assertEquals(0.3571, result.getValue("0").doubleValue(), 0.0000001d);
        assertEquals(1.0, result.getValue("1").doubleValue(), 0.0000001d);
        assertEquals(1.0, result.getValue("2").doubleValue(), 0.0000001d);
	}
	// LAB 2
	@Before
	public void setUpCumulativePercentageKeyedValues() throws Exception {
		DefaultKeyedValues perTest = new DefaultKeyedValues();
		keyedValues = perTest;
        perTest.addValue("0", 5);
        perTest.addValue("1", 9);
        perTest.addValue("2", 2);
	}
	
	@After
	public void tearDownCumulativePercentageKeyedValues() throws Exception {
		keyedValues = null;
	}
	
	@Test
	public void testValidCumulativePercentage() {
		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
		assertEquals(0.3125, result.getValue("0").doubleValue(), 0.0000001d);
        assertEquals(0.875, result.getValue("1").doubleValue(), 0.0000001d);
        assertEquals(1.0, result.getValue("2").doubleValue(), 0.0000001d);
	}
	
	@Test
	public void testNullCumulativePercentage() {
		try
		{
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Before
	public void setUpInvalidCumulativePercentageKeyedValues() throws Exception {
		DefaultKeyedValues perTest = new DefaultKeyedValues();
		negKeyedValues = perTest;
        perTest.addValue("0", 5);
        perTest.addValue("1", -9);
        perTest.addValue("2", 2);
	}
	
	@After
	public void tearDownInvalidCumulativePercentageKeyedValues() throws Exception {
		negKeyedValues = null;
	}
	
	@Test
	public void testInvalidCumluativePercentageKeyedValues() {
		try
		{
			DataUtilities.getCumulativePercentages(negKeyedValues);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Before
    public void setUpEmptyCumulativePercentageData() throws Exception {
        DefaultKeyedValues emptyDataSet = new DefaultKeyedValues();
        emptyKeyedValues = emptyDataSet;
    }

    @After
    public void tearDownEmptyCumulativePercentageData() throws Exception {
    	emptyKeyedValues = null;
    }

    @Test
    public void testEmptyCumulativePercentage() {
    	try
		{
			DataUtilities.getCumulativePercentages(emptyKeyedValues);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgument Exception");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
    }
}
