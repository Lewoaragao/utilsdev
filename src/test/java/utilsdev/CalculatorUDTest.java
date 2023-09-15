package utilsdev;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class CalculatorUDTest extends TestCase {

	// Integer
    public void testSumInteger() {
        assertEquals(new Integer(3), CalculatorUD.sum(new Integer(1), new Integer(2)));
    }

    public void testSubtractInteger() {
        assertEquals(new Integer(-1), CalculatorUD.subtract(new Integer(2), new Integer(3)));
    }

    public void testDivideInteger() {
        assertEquals(new Integer(2), CalculatorUD.divide(new Integer(6), new Integer(3)));
    }

    public void testMultiplyInteger() {
        assertEquals(new Integer(6), CalculatorUD.multiply(new Integer(2), new Integer(3)));
    }
    
    // int
    public void testSumInt() {
    	assertEquals(3, CalculatorUD.sum(1, 2));
    }
    
    public void testSubtractInt() {
    	assertEquals(-1, CalculatorUD.subtract(2, 3));
    }
    
    public void testDivideInt() {
    	assertEquals(2, CalculatorUD.divide(6, 3));
    }
    
    public void testMultiplyInt() {
    	assertEquals(6, CalculatorUD.multiply(2, 3));
    }

    // Double
    public void testSumDouble() {
        assertEquals(5.0, CalculatorUD.sum(2.0, 3.0), 0.001);
    }

    public void testSubtractDouble() {
        assertEquals(-1.0, CalculatorUD.subtract(2.0, 3.0), 0.001);
    }

    public void testDivideDouble() {
        assertEquals(2.0, CalculatorUD.divide(6.0, 3.0), 0.001);
    }

    public void testMultiplyDouble() {
        assertEquals(6.0, CalculatorUD.multiply(2.0, 3.0), 0.001);
    }
    
    // float
    public void testSumFloat() {
    	assertEquals(5.0f, CalculatorUD.sum(2.0f, 3.0f), 0.001f);
    }
    
    public void testSubtractFloat() {
    	assertEquals(-1.0f, CalculatorUD.subtract(2.0f, 3.0f), 0.001f);
    }
    
    public void testDivideFloat() {
    	assertEquals(2.0f, CalculatorUD.divide(6.0f, 3.0f), 0.001f);
    }
    
    public void testMultiplyFloat() {
    	assertEquals(6.0f, CalculatorUD.multiply(2.0f, 3.0f), 0.001f);
    }

    // BigDecimal
    public void testSumBigDecimal() {
        assertEquals(new BigDecimal("6.0"), CalculatorUD.sum(new BigDecimal("2.5"), new BigDecimal("3.5")));
    }

    public void testSubtractBigDecimal() {
        assertEquals(new BigDecimal("-1.0"), CalculatorUD.subtract(new BigDecimal("2.5"), new BigDecimal("3.5")));
    }

    public void testDivideBigDecimal() {
        assertEquals(new BigDecimal("1.5"), CalculatorUD.divide(new BigDecimal("6.0"), new BigDecimal("4.0")));
    }

    public void testMultiplyBigDecimal() {
        assertEquals(new BigDecimal("8.75"), CalculatorUD.multiply(new BigDecimal("2.5"), new BigDecimal("3.5")));
    }
    
    // Integer BigDecimal (Return Integer)
    public void testSumIntegerBigDecimal() {
        assertEquals(new Integer(3), CalculatorUD.sum(new Integer(1), new BigDecimal(2)));
    }

    public void testSubtractIntegerBigDecimal() {
        assertEquals(new Integer(-1), CalculatorUD.subtract(new Integer(2), new BigDecimal(3)));
    }

    public void testDivideIntegerBigDecimal() {
        assertEquals(new Integer(2), CalculatorUD.divide(new Integer(6), new BigDecimal(3)));
    }

    public void testMultiplyIntegerBigDecimal() {
        assertEquals(new Integer(6), CalculatorUD.multiply(new Integer(2), new BigDecimal(3)));
    }
    
    // Integer Double
}