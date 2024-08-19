package utilsdev;

import java.math.BigDecimal;

import utilsdev.utils.CalculatorUD;

/**
 * Hello world!
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 14/09/2023
 */
public class UtilsDev {

	/**
	 * Hello world!
	 * 
	 * @since 14/09/2023
	 */
	public UtilsDev() {
	}

	public static void main(String[] args) {
		System.out.println("Hello World UtilsDev!");
		
		Integer retorno = CalculatorUD.subtract(1, 2);
		System.out.println(retorno.toString());
	}

//	/**
//	 * Integer Calculator
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as an Integer.
//	 */
//	public static Integer sum(Integer numberOne, Integer numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as an
//	 *         Integer.
//	 */
//	public static Integer subtract(Integer numberOne, Integer numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as an Integer.
//	 */
//	public static Integer divide(Integer numberOne, Integer numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying the first parameter by the second as an
//	 *         Integer.
//	 */
//	public static Integer multiply(Integer numberOne, Integer numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * int Calculator
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as an int.
//	 */
//	public static int sum(int numberOne, int numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as an int.
//	 */
//	public static int subtract(int numberOne, int numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as an int.
//	 */
//	public static int divide(int numberOne, int numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying the first parameter by the second as an int.
//	 */
//	public static int multiply(int numberOne, int numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * Double Calculator
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as a Double.
//	 */
//	public static Double sum(Double numberOne, Double numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo
//	 * 
//	 *                  The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as a
//	 *         Double.
//	 */
//	public static Double subtract(Double numberOne, Double numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as a Double.
//	 */
//	public static Double divide(Double numberOne, Double numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying two Double numbers.
//	 */
//	public static Double multiply(Double numberOne, Double numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * float Calculator
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as a float.
//	 */
//	public static float sum(float numberOne, float numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as a float.
//	 */
//	public static float subtract(float numberOne, float numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as a float.
//	 */
//	public static float divide(float numberOne, float numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying two float numbers.
//	 */
//	public static float multiply(float numberOne, float numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * BigDecimal Calculator
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum between the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as a BigDecimal.
//	 */
//	public static BigDecimal sum(BigDecimal numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as a
//	 *         BigDecimal.
//	 */
//	public static BigDecimal subtract(BigDecimal numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as a BigDecimal.
//	 */
//	public static BigDecimal divide(BigDecimal numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying two BigDecimal numbers.
//	 */
//	public static BigDecimal multiply(BigDecimal numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * Integer BigDecimal Calculator (Returns Integer)
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as an Integer.
//	 */
//	public static Integer sum(Integer numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.sum(numberOne, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as an
//	 *         Integer.
//	 */
//	public static Integer subtract(Integer numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.subtract(numberOne, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as an Integer.
//	 */
//	public static Integer divide(Integer numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.divide(numberOne, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying the first parameter by the second as an
//	 *         Integer.
//	 */
//	public static Integer multiply(Integer numberOne, BigDecimal numberTwo) {
//		return CalculatorUD.multiply(numberOne, numberTwo);
//	}
//
//	/**
//	 * Integer Double Calculator (Returns Double)
//	 */
//
//	/**
//	 * Sum of two parameters, the first added to the second.
//	 * 
//	 * @param numberOne The first parameter for the sum of
//	 * 
//	 *                  the two parameters.
//	 * @param numberTwo The second parameter for the sum between the two parameters.
//	 * @return Result of adding the first parameter to the second as an Integer.
//	 */
//	public static Double sum(Integer numberOne, Double numberTwo) {
//		return CalculatorUD.sum(numberTwo, numberTwo);
//	}
//
//	/**
//	 * Subtraction of two parameters, the first subtracted from the second.
//	 * 
//	 * @param numberOne The first parameter for the subtraction between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the subtraction between the two
//	 *                  parameters.
//	 * @return Result of subtracting the first parameter from the second as an
//	 *         Integer.
//	 */
//	public static Double subtract(Integer numberOne, Double numberTwo) {
//		return CalculatorUD.subtract(numberTwo, numberTwo);
//	}
//
//	/**
//	 * Division of two parameters, the first divided by the second.
//	 * 
//	 * @param numberOne The first parameter for the division between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the division between the two
//	 *                  parameters.
//	 * @return Result of dividing the first parameter by the second as an Integer.
//	 */
//	public static Double divide(Integer numberOne, Double numberTwo) {
//		return CalculatorUD.divide(numberTwo, numberTwo);
//	}
//
//	/**
//	 * Multiplication of two parameters, the first multiplied by the second.
//	 * 
//	 * @param numberOne The first parameter for the multiplication between the two
//	 *                  parameters.
//	 * @param numberTwo The second parameter for the multiplication between the two
//	 *                  parameters.
//	 * @return Result of multiplying the first parameter by the second as an
//	 *         Integer.
//	 */
//	public static Double multiply(Integer numberOne, Double numberTwo) {
//		return CalculatorUD.multiply(numberTwo, numberTwo);
//	}
//
//	/**
//	 * Subtract two dates and return the number of days between them.
//	 *
//	 * @param date1 Initial date.
//	 * @param date2 Final date.
//	 * @return The number of days between the two dates.
//	 */
//	public static long calculateDaysDifference(Date initialDate, Date finalDate) {
//		return CalculatorUD.calculateDaysDifference(initialDate, finalDate);
//	}
//
//	/**
//	 * Subtract two dates and return the number of milliseconds between them.
//	 *
//	 * @param date1 Initial date.
//	 * @param date2 Final date.
//	 * @return The number of milliseconds between the two dates.
//	 */
//	public static long calculateDaysDifferenceInMillis(Date initialDate, Date finalDate) {
//		return CalculatorUD.calculateDaysDifferenceInMillis(initialDate, finalDate);
//	}
}
