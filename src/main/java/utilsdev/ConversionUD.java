package utilsdev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ConversionUD {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Conversion utilities.
	 * 
	 * @author Leonardo Aragão (@Lewoaragao)
	 * @since 14/09/2023
	 */
	public ConversionUD() {
	}

	/**
	 * Date to String Conversion.
	 * 
	 * @param date Parameter in Date format that will be converted to String.
	 * @return String in the format "yyyy-MM-dd" with "yyyy" being the year, "MM"
	 *         the month and "dd" the day.
	 */
	public static String convertDateToString(Date date) {
		return sdf.format(date);
	}

	/**
	 * String to Date Conversion.
	 * 
	 * @param dateString Parameter in String format "yyyy-MM-dd", with "yyyy" being
	 *                   the year, "MM" the month and "dd" the day, which will be
	 *                   converted to Date.
	 * @return Date
	 * @throws ParseException Exception if conversion is not possible.
	 */
	public static Date convertStringToDate(String dateString) throws ParseException {
		return sdf.parse(dateString);
	}

	/**
	 * Converte um objeto Date em um objeto LocalDateTime.
	 *
	 * @param date O objeto Date a ser convertido.
	 * @return Um objeto LocalDateTime representando a mesma data e hora que o
	 *         objeto Date.
	 */
	public static LocalDateTime convertDateToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * Converte um objeto LocalDateTime em um objeto Date.
	 *
	 * @param localDateTime O objeto LocalDateTime a ser convertido.
	 * @return Um objeto Date representando a mesma data e hora que o objeto
	 *         LocalDateTime.
	 */
	public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Converte um objeto Date em um objeto ZonedDateTime.
	 *
	 * @param date O objeto Date a ser convertido.
	 * @return Um objeto ZonedDateTime representando a mesma data e hora que o
	 *         objeto Date.
	 */
	public static ZonedDateTime convertDateToZonedDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault());
	}

	/**
	 * Converte um objeto ZonedDateTime em um objeto Date.
	 *
	 * @param dateTime O objeto ZonedDateTime a ser convertido.
	 * @return Um objeto Date representando a mesma data e hora que o objeto
	 *         ZonedDateTime.
	 */
	public static Date convertZonedDateTimeToDate(ZonedDateTime dateTime) {
		return Date.from(dateTime.toInstant());
	}

	/**
	 * Converte um objeto Integer em uma String.
	 *
	 * @param integer O objeto Integer a ser convertido em String.
	 * @return Uma String representando o valor do Integer.
	 */
	public static String integerToString(Integer integer) {
		if (integer == null)
			throw new IllegalArgumentException("O valor do Integer não pode ser nulo.");
		return Integer.toString(integer);
	}

	/**
	 * Converte uma String em um objeto Integer.
	 *
	 * @param str A String a ser convertida em Integer.
	 * @return Um objeto Integer representando o valor contido na String.
	 * @throws NumberFormatException Se a String não puder ser analisada como um
	 *                               Integer válido.
	 */
	public static Integer stringToInteger(String string) {
		if (string == null)
			throw new IllegalArgumentException("A String de entrada não pode ser nula.");
		return Integer.parseInt(string);
	}

	/**
	 * Converte um valor int em uma String.
	 *
	 * @param intValue O valor int a ser convertido em String.
	 * @return Uma String representando o valor int.
	 */
	public static String intToString(int intValue) {
		return Integer.toString(intValue);
	}

	/**
	 * Converte uma String em um valor int.
	 *
	 * @param str A String a ser convertida em int.
	 * @return Um valor int representando o valor contido na String.
	 * @throws NumberFormatException Se a String não puder ser analisada como um int
	 *                               válido.
	 */
	public static int stringToInt(String str) {
		return Integer.parseInt(str);
	}

}