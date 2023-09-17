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
 * @since 14/09/2023
 */
public class ConversionUD {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Conversion utilities.
	 * 
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
	public static String dateToString(Date date) {
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
	public static Date stringToDate(String dateString) throws ParseException {
		return sdf.parse(dateString);
	}

	/**
	 * Converte um objeto Date em um objeto LocalDateTime.
	 *
	 * @param date O objeto Date a ser convertido.
	 * @return Um objeto LocalDateTime representando a mesma data e hora que o
	 *         objeto Date.
	 */
	public static LocalDateTime dateToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * Converte um objeto LocalDateTime em um objeto Date.
	 *
	 * @param localDateTime O objeto LocalDateTime a ser convertido.
	 * @return Um objeto Date representando a mesma data e hora que o objeto
	 *         LocalDateTime.
	 */
	public static Date localDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Converte um objeto Date em um objeto ZonedDateTime.
	 *
	 * @param date O objeto Date a ser convertido.
	 * @return Um objeto ZonedDateTime representando a mesma data e hora que o
	 *         objeto Date.
	 */
	public static ZonedDateTime dateToZonedDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault());
	}

	/**
	 * Converte um objeto ZonedDateTime em um objeto Date.
	 *
	 * @param dateTime O objeto ZonedDateTime a ser convertido.
	 * @return Um objeto Date representando a mesma data e hora que o objeto
	 *         ZonedDateTime.
	 */
	public static Date zonedDateTimeToDate(ZonedDateTime dateTime) {
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
	 * @param string A String a ser convertida em Integer.
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

	/**
	 * Converte a temperatura de Celsius para Fahrenheit.
	 *
	 * @param celsius A temperatura em graus Celsius.
	 * @return A temperatura em graus Fahrenheit.
	 */
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	/**
	 * Converte a temperatura de Fahrenheit para Celsius.
	 *
	 * @param fahrenheit A temperatura em graus Fahrenheit.
	 * @return A temperatura em graus Celsius.
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	/**
	 * Converte horas em minutos.
	 *
	 * @param hours As horas a serem convertidas.
	 * @return O equivalente em minutos.
	 */
	public static int hoursToMinutes(int hours) {
		return hours * 60;
	}

	/**
	 * Converte minutos em horas.
	 *
	 * @param minutes Os minutos a serem convertidos.
	 * @return O equivalente em horas.
	 */
	public static int minutesToHours(int minutes) {
		return minutes / 60;
	}

	/**
	 * Converte horas em milissegundos.
	 *
	 * @param hours As horas a serem convertidas.
	 * @return O equivalente em milissegundos.
	 */
	public static long hoursToMilliseconds(int hours) {
		return (long) hours * 60 * 60 * 1000;
	}

	/**
	 * Converte milissegundos em horas.
	 *
	 * @param milliseconds Os milissegundos a serem convertidos.
	 * @return O equivalente em horas.
	 */
	public static int millisecondsToHours(long milliseconds) {
		return (int) (milliseconds / (60 * 60 * 1000));
	}

	/**
	 * Converte minutos em milissegundos.
	 *
	 * @param minutes Os minutos a serem convertidos.
	 * @return O equivalente em milissegundos.
	 */
	public static long minutesToMilliseconds(int minutes) {
		return (long) minutes * 60 * 1000;
	}

	/**
	 * Converte milissegundos em minutos.
	 *
	 * @param milliseconds Os milissegundos a serem convertidos.
	 * @return O equivalente em minutos.
	 */
	public static int millisecondsToMinutes(long milliseconds) {
		return (int) (milliseconds / (60 * 1000));
	}

	/**
	 * Converte horas em segundos.
	 *
	 * @param hours As horas a serem convertidas.
	 * @return O equivalente em segundos.
	 */
	public static int hoursToSeconds(int hours) {
		return hours * 3600;
	}

	/**
	 * Converte segundos em horas.
	 *
	 * @param seconds Os segundos a serem convertidos.
	 * @return O equivalente em horas.
	 */
	public static int secondsToHours(int seconds) {
		return seconds / 3600;
	}

	/**
	 * Converte segundos em minutos.
	 *
	 * @param seconds Os segundos a serem convertidos.
	 * @return O equivalente em minutos.
	 */
	public static int secondsToMinutes(int seconds) {
		return seconds / 60;
	}

	/**
	 * Converte minutos em segundos.
	 *
	 * @param minutes Os minutos a serem convertidos.
	 * @return O equivalente em segundos.
	 */
	public static int minutesToSeconds(int minutes) {
		return minutes * 60;
	}

	/**
	 * Converte segundos em milissegundos.
	 *
	 * @param seconds Os segundos a serem convertidos.
	 * @return O equivalente em milissegundos.
	 */
	public static long secondsToMilliseconds(int seconds) {
		return seconds * 1000L;
	}

	/**
	 * Converte milissegundos em segundos.
	 *
	 * @param milliseconds Os milissegundos a serem convertidos.
	 * @return O equivalente em segundos.
	 */
	public static int millisecondsToSeconds(long milliseconds) {
		return (int) (milliseconds / 1000L);
	}

	/**
	 * Converte um HashMap em uma lista de pares chave-valor.
	 *
	 * @param <K> O tipo da chave no HashMap.
	 * @param <V> O tipo do valor no HashMap.
	 * @param map O HashMap a ser convertido.
	 * @return Uma lista de pares chave-valor representando o HashMap.
	 */
	public static <K, V> List<Map.Entry<K, V>> convertHashMapToList(HashMap<K, V> map) {
		return new ArrayList<>(map.entrySet());
	}

	/**
	 * Converte uma lista de pares chave-valor em um HashMap.
	 *
	 * @param <K>  O tipo da chave no HashMap.
	 * @param <V>  O tipo do valor no HashMap.
	 * @param list A lista de pares chave-valor.
	 * @return Um HashMap representado pela lista de pares chave-valor.
	 */
	public static <K, V> HashMap<K, V> convertListToHashMap(List<Map.Entry<K, V>> list) {
		HashMap<K, V> map = new HashMap<>();
		for (Map.Entry<K, V> entry : list) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

}