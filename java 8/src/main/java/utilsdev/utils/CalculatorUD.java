package utilsdev.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Calculation utilities.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 14/09/2023
 */
public class CalculatorUD {

	/**
	 * Calculation utilities.
	 * 
	 * @since 14/09/2023
	 */
	public CalculatorUD() {
	}

	/**
	 * Sums two numbers of the same type and returns the result.
	 * 
	 * @param <T>       the type of the numbers to be summed, must extend Number
	 * @param numberOne the first number to be summed
	 * @param numberTwo the second number to be summed
	 * @return the sum of the two numbers
	 * @throws IllegalArgumentException if the numbers are null or their type is not
	 *                                  supported
	 */
	public static <T extends Number> BigDecimal sum(T numberOne, T numberTwo) {
    	return sum(numberOne, numberTwo, BigDecimal.class);
    }
    
    public static <T extends Number, R extends Number> R sum(T numberOne, T numberTwo, Class<R> returnType) {
    	VerifyUD.isNull(numberOne);
    	VerifyUD.isNull(numberTwo);
    	
    	BigDecimal result;

        if (numberOne instanceof Integer && numberTwo instanceof Integer)
            result = BigDecimal.valueOf(numberOne.intValue()).add(BigDecimal.valueOf(numberTwo.intValue()));
        else if (numberOne instanceof Double && numberTwo instanceof Double)
            result = BigDecimal.valueOf(numberOne.doubleValue()).add(BigDecimal.valueOf(numberTwo.doubleValue()));
        else if (numberOne instanceof Long && numberTwo instanceof Long)
            result = BigDecimal.valueOf(numberOne.longValue()).add(BigDecimal.valueOf(numberTwo.longValue()));
        else if (numberOne instanceof Float && numberTwo instanceof Float)
            result = BigDecimal.valueOf(numberOne.floatValue()).add(BigDecimal.valueOf(numberTwo.floatValue()));
        else if (numberOne instanceof Short && numberTwo instanceof Short)
            result = BigDecimal.valueOf(numberOne.shortValue()).add(BigDecimal.valueOf(numberTwo.shortValue()));
        else if (numberOne instanceof Byte && numberTwo instanceof Byte)
            result = BigDecimal.valueOf(numberOne.byteValue()).add(BigDecimal.valueOf(numberTwo.byteValue()));
        else if (numberOne instanceof BigDecimal && numberTwo instanceof BigDecimal)
            result = ((BigDecimal) numberOne).add((BigDecimal) numberTwo);
        // Different types
        else if (numberOne instanceof Number && numberTwo instanceof BigDecimal)
            result = ConvertUD.toBigDecimal(numberOne).add((BigDecimal) numberTwo);
        else if (numberOne instanceof BigDecimal && numberTwo instanceof Number)
            result = ((BigDecimal) numberOne).add(ConvertUD.toBigDecimal(numberTwo));
        else
            throw ConstantsUD.EXCEPTION_UNSUPPORTED_NUMBER_TYPE;

        // Convert the result to the specified return type
        return ConvertUD.convertToReturnType(result, returnType);
    }

	/**
	 * Subtracts two numbers of the same type and returns the result as BigDecimal.
	 * 
	 * @param <T>       the type of the numbers to be summed, must extend Number
	 * @param numberOne the first number to be subtracted
	 * @param numberTwo the second number to be subtracted
	 * @return the subtract of the two numbers
	 * @throws IllegalArgumentException if the numbers are null or their type is not
	 *                                  supported
	 */
    public static <T extends Number> BigDecimal subtract(T numberOne, T numberTwo) {
    	return subtract(numberOne, numberTwo, BigDecimal.class);
    }
    
    public static <T extends Number, R extends Number> R subtract(T numberOne, T numberTwo, Class<R> returnType) {
    	VerifyUD.isNull(numberOne);
    	VerifyUD.isNull(numberTwo);
    	
    	BigDecimal result;

        if (numberOne instanceof Integer && numberTwo instanceof Integer)
            result = BigDecimal.valueOf(numberOne.intValue()).subtract(BigDecimal.valueOf(numberTwo.intValue()));
        else if (numberOne instanceof Double && numberTwo instanceof Double)
            result = BigDecimal.valueOf(numberOne.doubleValue()).subtract(BigDecimal.valueOf(numberTwo.doubleValue()));
        else if (numberOne instanceof Long && numberTwo instanceof Long)
            result = BigDecimal.valueOf(numberOne.longValue()).subtract(BigDecimal.valueOf(numberTwo.longValue()));
        else if (numberOne instanceof Float && numberTwo instanceof Float)
            result = BigDecimal.valueOf(numberOne.floatValue()).subtract(BigDecimal.valueOf(numberTwo.floatValue()));
        else if (numberOne instanceof Short && numberTwo instanceof Short)
            result = BigDecimal.valueOf(numberOne.shortValue()).subtract(BigDecimal.valueOf(numberTwo.shortValue()));
        else if (numberOne instanceof Byte && numberTwo instanceof Byte)
            result = BigDecimal.valueOf(numberOne.byteValue()).subtract(BigDecimal.valueOf(numberTwo.byteValue()));
        else if (numberOne instanceof BigDecimal && numberTwo instanceof BigDecimal)
            result = ((BigDecimal) numberOne).subtract((BigDecimal) numberTwo);
        // Different types
        else if (numberOne instanceof Number && numberTwo instanceof BigDecimal)
            result = ConvertUD.toBigDecimal(numberOne).subtract((BigDecimal) numberTwo);
        else if (numberOne instanceof BigDecimal && numberTwo instanceof Number)
            result = ((BigDecimal) numberOne).subtract(ConvertUD.toBigDecimal(numberTwo));
        else
            throw ConstantsUD.EXCEPTION_UNSUPPORTED_NUMBER_TYPE;

        // Convert the result to the specified return type
        return ConvertUD.convertToReturnType(result, returnType);
    }

	/**
	 * Multiplies two numbers of the same type and returns the result.
	 * 
	 * @param <T>       the type of the numbers to be summed, must extend Number
	 * @param numberOne the first number to be multiplied
	 * @param numberTwo the second number to be multiplied
	 * @return the multiply of the two numbers
	 * @throws IllegalArgumentException if the numbers are null or their type is not
	 *                                  supported
	 */
    public static <T extends Number> BigDecimal multiply(T numberOne, T numberTwo) {
    	return multiply(numberOne, numberTwo, BigDecimal.class);
    }
    
    public static <T extends Number, R extends Number> R multiply(T numberOne, T numberTwo, Class<R> returnType) {
    	VerifyUD.isNull(numberOne);
    	VerifyUD.isNull(numberTwo);
    	
    	BigDecimal result;

        if (numberOne instanceof Integer && numberTwo instanceof Integer)
            result = BigDecimal.valueOf(numberOne.intValue()).multiply(BigDecimal.valueOf(numberTwo.intValue()));
        else if (numberOne instanceof Double && numberTwo instanceof Double)
            result = BigDecimal.valueOf(numberOne.doubleValue()).multiply(BigDecimal.valueOf(numberTwo.doubleValue()));
        else if (numberOne instanceof Long && numberTwo instanceof Long)
            result = BigDecimal.valueOf(numberOne.longValue()).multiply(BigDecimal.valueOf(numberTwo.longValue()));
        else if (numberOne instanceof Float && numberTwo instanceof Float)
            result = BigDecimal.valueOf(numberOne.floatValue()).multiply(BigDecimal.valueOf(numberTwo.floatValue()));
        else if (numberOne instanceof Short && numberTwo instanceof Short)
            result = BigDecimal.valueOf(numberOne.shortValue()).multiply(BigDecimal.valueOf(numberTwo.shortValue()));
        else if (numberOne instanceof Byte && numberTwo instanceof Byte)
            result = BigDecimal.valueOf(numberOne.byteValue()).multiply(BigDecimal.valueOf(numberTwo.byteValue()));
        else if (numberOne instanceof BigDecimal && numberTwo instanceof BigDecimal)
            result = ((BigDecimal) numberOne).multiply((BigDecimal) numberTwo);
        // Different types
        else if (numberOne instanceof Number && numberTwo instanceof BigDecimal)
            result = ConvertUD.toBigDecimal(numberOne).multiply((BigDecimal) numberTwo);
        else if (numberOne instanceof BigDecimal && numberTwo instanceof Number)
            result = ((BigDecimal) numberOne).multiply(ConvertUD.toBigDecimal(numberTwo));
        else
            throw ConstantsUD.EXCEPTION_UNSUPPORTED_NUMBER_TYPE;

        // Convert the result to the specified return type
        return ConvertUD.convertToReturnType(result, returnType);
    }

	/**
	 * Divides two numbers of the same type and returns the result.
	 * 
	 * @param <T>       the type of the numbers to be summed, must extend Number
	 * @param numberOne the first number to be divided
	 * @param numberTwo the second number to be divided
	 * @return the divide of the two numbers
	 * @throws IllegalArgumentException if the numbers are null or their type is not
	 *                                  supported
	 */
    public static <T extends Number> BigDecimal divide(T numberOne, T numberTwo) {
    	return divide(numberOne, numberTwo, BigDecimal.class);
    }
    
    public static <T extends Number, R extends Number> R divide(T numberOne, T numberTwo, Class<R> returnType) {
    	VerifyUD.isNull(numberOne);
    	VerifyUD.isNull(numberTwo);
    	
    	BigDecimal result;

        if (numberOne instanceof Integer && numberTwo instanceof Integer)
            result = BigDecimal.valueOf(numberOne.intValue()).divide(BigDecimal.valueOf(numberTwo.intValue()));
        else if (numberOne instanceof Double && numberTwo instanceof Double)
            result = BigDecimal.valueOf(numberOne.doubleValue()).divide(BigDecimal.valueOf(numberTwo.doubleValue()));
        else if (numberOne instanceof Long && numberTwo instanceof Long)
            result = BigDecimal.valueOf(numberOne.longValue()).divide(BigDecimal.valueOf(numberTwo.longValue()));
        else if (numberOne instanceof Float && numberTwo instanceof Float)
            result = BigDecimal.valueOf(numberOne.floatValue()).divide(BigDecimal.valueOf(numberTwo.floatValue()));
        else if (numberOne instanceof Short && numberTwo instanceof Short)
            result = BigDecimal.valueOf(numberOne.shortValue()).divide(BigDecimal.valueOf(numberTwo.shortValue()));
        else if (numberOne instanceof Byte && numberTwo instanceof Byte)
            result = BigDecimal.valueOf(numberOne.byteValue()).divide(BigDecimal.valueOf(numberTwo.byteValue()));
        else if (numberOne instanceof BigDecimal && numberTwo instanceof BigDecimal)
            result = ((BigDecimal) numberOne).divide((BigDecimal) numberTwo);
        // Different types
        else if (numberOne instanceof Number && numberTwo instanceof BigDecimal)
            result = ConvertUD.toBigDecimal(numberOne).divide((BigDecimal) numberTwo);
        else if (numberOne instanceof BigDecimal && numberTwo instanceof Number)
            result = ((BigDecimal) numberOne).divide(ConvertUD.toBigDecimal(numberTwo));
        else
            throw ConstantsUD.EXCEPTION_UNSUPPORTED_NUMBER_TYPE;

        // Convert the result to the specified return type
        return ConvertUD.convertToReturnType(result, returnType);
    }

	/**
	 * Subtract two dates and return the number of days between them.
	 *
	 * @param date1 The initial date.
	 * @param date2 The final date.
	 * @return The number of days between the two dates.
	 */
	public static long calculateDaysDifference(Date initialDate, Date finalDate) {
		VerifyUD.isNull(initialDate);
		VerifyUD.isNull(finalDate);
		long millisecondsPerDay = 24 * 60 * 60 * 1000L;
		long differenceInMillis = Math.abs(initialDate.getTime() - finalDate.getTime());
		return differenceInMillis / millisecondsPerDay;
	}

	/**
	 * Subtract two dates and return the number of milliseconds between them.
	 *
	 * @param date1 The initial date.
	 * @param date2 The final date.
	 * @return The number of milliseconds between the two dates.
	 */
	public static long calculateDaysDifferenceInMillis(Date initialDate, Date finalDate) {
		VerifyUD.isNull(initialDate);
		VerifyUD.isNull(finalDate);
		return Math.abs(initialDate.getTime() - finalDate.getTime());
	}
}
