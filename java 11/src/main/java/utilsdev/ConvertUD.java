package utilsdev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Conversion utilities.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 09/14/2023
 */
public class ConvertUD {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Conversion utilities.
	 * 
	 * @since 09/14/2023
	 */
	public ConvertUD() {
	}

	/**
	 * Date to String Conversion.
	 * 
	 * @param date Date parameter to be converted to a String.
	 * @return A String in the "yyyy-MM-dd" format, where "yyyy" is the year, "MM"
	 *         is the month, and "dd" is the day.
	 */
	public static String dateToString(Date date) {
		return sdf.format(date);
	}

	/**
	 * String to Date Conversion.
	 * 
	 * @param dateString A String in "yyyy-MM-dd" format, where "yyyy" is the year,
	 *                   "MM" is the month, and "dd" is the day, to be converted to
	 *                   a Date.
	 * @return A Date.
	 * @throws ParseException Exception thrown if conversion is not possible.
	 */
	public static Date stringToDate(String dateString) throws ParseException {
		return sdf.parse(dateString);
	}

	/**
	 * Converts a Date object to a LocalDateTime object.
	 *
	 * @param date The Date object to be converted.
	 * @return A LocalDateTime object representing the same date and time as the
	 *         Date object.
	 */
	public static LocalDateTime dateToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * Converts a LocalDateTime object to a Date object.
	 *
	 * @param localDateTime The LocalDateTime object to be converted.
	 * @return A Date object representing the same date and time as the
	 *         LocalDateTime object.
	 */
	public static Date localDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Converts a Date object to a ZonedDateTime object.
	 *
	 * @param date The Date object to be converted.
	 * @return A ZonedDateTime object representing the same date and time as the
	 *         Date object.
	 */
	public static ZonedDateTime dateToZonedDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault());
	}

	/**
	 * Converts a ZonedDateTime object to a Date object.
	 *
	 * @param dateTime The ZonedDateTime object to be converted.
	 * @return A Date object representing the same date and time as the
	 *         ZonedDateTime object.
	 */
	public static Date zonedDateTimeToDate(ZonedDateTime dateTime) {
		return Date.from(dateTime.toInstant());
	}

	/**
	 * Converts an Integer object to a String.
	 *
	 * @param integer The Integer object to be converted to a String.
	 * @return A String representing the value of the Integer.
	 */
	public static String integerToString(Integer integer) {
		if (integer == null)
			throw new IllegalArgumentException("The Integer value cannot be null.");
		return Integer.toString(integer);
	}

	/**
	 * Converts a String to an Integer object.
	 *
	 * @param string The input String to be converted to an Integer.
	 * @return An Integer object representing the value contained in the String.
	 * @throws NumberFormatException If the String cannot be parsed as a valid
	 *                               Integer.
	 */
	public static Integer stringToInteger(String string) {
		if (string == null)
			throw new IllegalArgumentException("The input String cannot be null.");
		return Integer.parseInt(string);
	}

	/**
	 * Converts an int value to a String.
	 *
	 * @param intValue The int value to be converted to a String.
	 * @return A String representing the int value.
	 */
	public static String intToString(int intValue) {
		return Integer.toString(intValue);
	}

	/**
	 * Converts a String to an int value.
	 *
	 * @param str The String to be converted to an int.
	 * @return An int value representing the value contained in the String.
	 * @throws NumberFormatException If the String cannot be parsed as a valid int.
	 */
	public static int stringToInt(String str) {
		return Integer.parseInt(str);
	}

	/**
	 * Converts temperature from Celsius to Fahrenheit.
	 *
	 * @param celsius The temperature in degrees Celsius.
	 * @return The temperature in degrees Fahrenheit.
	 */
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	/**
	 * Converts temperature from Fahrenheit to Celsius.
	 *
	 * @param fahrenheit The temperature in degrees Fahrenheit.
	 * @return The temperature in degrees Celsius.
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	/**
	 * Converts hours to minutes.
	 *
	 * @param hours The hours to be converted.
	 * @return The equivalent in minutes.
	 */
	public static int hoursToMinutes(int hours) {
		return hours * 60;
	}

	/**
	 * Converts minutes to hours.
	 *
	 * @param minutes The minutes to be converted.
	 * @return The equivalent in hours.
	 */
	public static int minutesToHours(int minutes) {
		return minutes / 60;
	}

	/**
	 * Converts hours to milliseconds.
	 *
	 * @param hours The hours to be converted.
	 * @return The equivalent in milliseconds.
	 */
	public static long hoursToMilliseconds(int hours) {
		return (long) hours * 60 * 60 * 1000;
	}

	/**
	 * Converts milliseconds to hours.
	 *
	 * @param milliseconds The milliseconds to be converted.
	 * @return The equivalent in hours.
	 */
	public static int millisecondsToHours(long milliseconds) {
		return (int) (milliseconds / (60 * 60 * 1000));
	}

	/**
	 * Converts minutes to milliseconds.
	 *
	 * @param minutes The minutes to be converted.
	 * @return The equivalent in milliseconds.
	 */
	public static long minutesToMilliseconds(int minutes) {
		return (long) minutes * 60 * 1000;
	}

	/**
	 * Converts milliseconds to minutes.
	 *
	 * @param milliseconds The milliseconds to be converted.
	 * @return The equivalent in minutes.
	 */
	public static int millisecondsToMinutes(long milliseconds) {
		return (int) (milliseconds / (60 * 1000));
	}

	/**
	 * Converts hours to seconds.
	 *
	 * @param hours The hours to be converted.
	 * @return The equivalent in seconds.
	 */
	public static int hoursToSeconds(int hours) {
		return hours * 3600;
	}

	/**
	 * Converts seconds to hours.
	 *
	 * @param seconds The seconds to be converted.
	 * @return The equivalent in hours.
	 */
	public static int secondsToHours(int seconds) {
		return seconds / 3600;
	}

	/**
	 * Converts seconds to minutes.
	 *
	 * @param seconds The seconds to be converted.
	 * @return The equivalent in minutes.
	 */
	public static int secondsToMinutes(int seconds) {
		return seconds / 60;
	}

	/**
	 * Converts minutes to seconds.
	 *
	 * @param minutes The minutes to be converted.
	 * @return The equivalent in seconds.
	 */
	public static int minutesToSeconds(int minutes) {
		return minutes * 60;
	}

	/**
	 * Converts seconds to milliseconds.
	 *
	 * @param seconds The seconds to be converted.
	 * @return The equivalent in milliseconds.
	 */
	public static long secondsToMilliseconds(int seconds) {
		return seconds * 1000L;
	}

	/**
	 * Converts milliseconds to seconds.
	 *
	 * @param milliseconds The milliseconds to be converted.
	 * @return The equivalent in seconds.
	 */
	public static int millisecondsToSeconds(long milliseconds) {
		return (int) (milliseconds / 1000L);
	}

	/**
	 * Converts a HashMap into a list of key-value pairs.
	 *
	 * @param <K> The type of the key in the HashMap.
	 * @param <V> The type of the value in the HashMap.
	 * @param map The HashMap to be converted.
	 * @return A list of key-value pairs representing the HashMap.
	 */
	public static <K, V> List<Map.Entry<K, V>> convertHashMapToList(HashMap<K, V> map) {
		return new ArrayList<>(map.entrySet());
	}

	/**
	 * Converts a list of key-value pairs into a HashMap.
	 *
	 * @param <K>  The type of the key in the HashMap.
	 * @param <V>  The type of the value in the HashMap.
	 * @param list The list of key-value pairs.
	 * @return A HashMap represented by the list of key-value pairs.
	 */
	public static <K, V> HashMap<K, V> convertListToHashMap(List<Map.Entry<K, V>> list) {
		HashMap<K, V> map = new HashMap<>();
		for (Map.Entry<K, V> entry : list) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}
}
