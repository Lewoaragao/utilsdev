package utilsdev.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import utilsdev.utils.ConvertUD;

/**
 * ConversionUD class tests.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 09/14/2023
 */
public class ConvertUDTest extends TestCase {

	public void testDateToString() {
		// Create a sample date
		Date date = new Date();

		// Call the conversion method
		String dateString = ConvertUD.dateToString(date);

		// Verify if the converted date is in the expected format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.format(date), dateString);
	}

	public void testStringToDate() throws ParseException {
		// Sample date string
		String dateString = "2023-09-14";

		// Call the conversion method
		Date date = ConvertUD.stringToDate(dateString);

		// Verify if the converted date matches the sample date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.parse(dateString), date);
	}

	public void testConvertDateToLocalDateTime() {
		// Create a sample date
		Date date = new Date();

		// Call the conversion method
		LocalDateTime localDateTime = ConvertUD.dateToLocalDateTime(date);

		// Verify if the date and time were converted correctly
		assertNotNull(localDateTime);

		// Convert back to Date and check if they are equal
		Date convertedDate = ConvertUD.localDateTimeToDate(localDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertLocalDateTimeToDate() {
		// Create a sample LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now();

		// Call the conversion method
		Date date = ConvertUD.localDateTimeToDate(localDateTime);

		// Verify if the date was converted correctly
		assertNotNull(date);

		// Convert back to LocalDateTime and check if they are equal
		LocalDateTime convertedLocalDateTime = ConvertUD.dateToLocalDateTime(date);
		assertEquals(localDateTime, convertedLocalDateTime);
	}

	public void testConvertDateToDateTime() {
		// Create a sample date
		Date date = new Date();

		// Call the conversion method
		ZonedDateTime zonedDateTime = ConvertUD.dateToZonedDateTime(date);

		// Verify if the ZonedDateTime was created correctly
		assertNotNull(zonedDateTime);

		// Convert back to Date and check if they are equal
		Date convertedDate = ConvertUD.zonedDateTimeToDate(zonedDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertDateTimeToDate() {
		// Create a sample ZonedDateTime
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());

		// Call the conversion method
		Date date = ConvertUD.zonedDateTimeToDate(zonedDateTime);

		// Verify if the date was converted correctly
		assertNotNull(date);

		// Convert back to ZonedDateTime and check if they are equal
		ZonedDateTime convertedZonedDateTime = ConvertUD.dateToZonedDateTime(date);
		assertEquals(zonedDateTime, convertedZonedDateTime);
	}

	// Unit test for integerToString
	public void testIntegerToString() {
		assertEquals("10", ConvertUD.integerToString(10));
		assertEquals("0", ConvertUD.integerToString(0));
		assertEquals("-5", ConvertUD.integerToString(-5));
	}

	// Unit test for stringToInteger
	public void testStringToInteger() {
		assertEquals(Integer.valueOf(10), ConvertUD.stringToInteger("10"));
		assertEquals(Integer.valueOf(0), ConvertUD.stringToInteger("0"));
		assertEquals(Integer.valueOf(-5), ConvertUD.stringToInteger("-5"));
	}

	// Unit test for stringToInteger with expected exception
	public void testStringToIntegerWithException() {
		try {
			ConvertUD.stringToInteger("abc"); // This should throw NumberFormatException
			fail("A NumberFormatException should be thrown.");
		} catch (NumberFormatException e) {
			// Expected exception
		}
	}

	// Unit test for intToString
	public void testIntToString() {
		assertEquals("10", ConvertUD.intToString(10));
		assertEquals("0", ConvertUD.intToString(0));
		assertEquals("-5", ConvertUD.intToString(-5));
	}

	// Unit test for stringToInt
	public void testStringToInt() {
		assertEquals(10, ConvertUD.stringToInt("10"));
		assertEquals(0, ConvertUD.stringToInt("0"));
		assertEquals(-5, ConvertUD.stringToInt("-5"));
	}

	// Unit test for stringToInt with expected exception
	public void testStringToIntWithException() {
		try {
			ConvertUD.stringToInt("abc"); // This should throw NumberFormatException
			fail("A NumberFormatException should be thrown.");
		} catch (NumberFormatException e) {
			// Expected exception
		}
	}

	// Unit test for celsiusToFahrenheit
	public void testCelsiusToFahrenheit() {
		assertEquals(32.0, ConvertUD.celsiusToFahrenheit(0.0));
		assertEquals(68.0, ConvertUD.celsiusToFahrenheit(20.0));
		assertEquals(212.0, ConvertUD.celsiusToFahrenheit(100.0));
	}

	// Unit test for fahrenheitToCelsius
	public void testFahrenheitToCelsius() {
		assertEquals(0.0, ConvertUD.fahrenheitToCelsius(32.0));
		assertEquals(20.0, ConvertUD.fahrenheitToCelsius(68.0));
		assertEquals(100.0, ConvertUD.fahrenheitToCelsius(212.0));
	}

	// Unit test for hoursToMinutes
	public void testHoursToMinutes() {
		assertEquals(0, ConvertUD.hoursToMinutes(0));
		assertEquals(60, ConvertUD.hoursToMinutes(1));
		assertEquals(120, ConvertUD.hoursToMinutes(2));
	}

	// Unit test for minutesToHours
	public void testMinutesToHours() {
		assertEquals(0, ConvertUD.minutesToHours(0));
		assertEquals(1, ConvertUD.minutesToHours(60));
		assertEquals(2, ConvertUD.minutesToHours(120));
	}

	// Unit test for hoursToMilliseconds
	public void testHoursToMilliseconds() {
		assertEquals(0L, ConvertUD.hoursToMilliseconds(0));
		assertEquals(3600000L, ConvertUD.hoursToMilliseconds(1));
		assertEquals(7200000L, ConvertUD.hoursToMilliseconds(2));
	}

	// Unit test for millisecondsToHours
	public void testMillisecondsToHours() {
		assertEquals(0, ConvertUD.millisecondsToHours(0L));
		assertEquals(1, ConvertUD.millisecondsToHours(3600000L));
		assertEquals(2, ConvertUD.millisecondsToHours(7200000L));
	}

	// Unit test for minutesToMilliseconds
	public void testMinutesToMilliseconds() {
		assertEquals(0L, ConvertUD.minutesToMilliseconds(0));
		assertEquals(60000L, ConvertUD.minutesToMilliseconds(1));
		assertEquals(120000L, ConvertUD.minutesToMilliseconds(2));
	}

	// Unit test for millisecondsToMinutes
	public void testMillisecondsToMinutes() {
		assertEquals(0, ConvertUD.millisecondsToMinutes(0L));
		assertEquals(1, ConvertUD.millisecondsToMinutes(60000L));
		assertEquals(2, ConvertUD.millisecondsToMinutes(120000L));
	}

	// Unit test for hoursToSeconds
	public void testHoursToSeconds() {
		assertEquals(0, ConvertUD.hoursToSeconds(0));
		assertEquals(3600, ConvertUD.hoursToSeconds(1));
		assertEquals(7200, ConvertUD.hoursToSeconds(2));
	}

	// Unit test for secondsToHours
	public void testSecondsToHours() {
		assertEquals(0, ConvertUD.secondsToHours(0));
		assertEquals(1, ConvertUD.secondsToHours(3600));
		assertEquals(2, ConvertUD.secondsToHours(7200));
	}

	// Unit test for secondsToMinutes
	public void testSecondsToMinutes() {
		assertEquals(0, ConvertUD.secondsToMinutes(0));
		assertEquals(1, ConvertUD.secondsToMinutes(60));
		assertEquals(2, ConvertUD.secondsToMinutes(120));
	}

	// Unit test for minutesToSeconds
	public void testMinutesToSeconds() {
		assertEquals(0, ConvertUD.minutesToSeconds(0));
		assertEquals(60, ConvertUD.minutesToSeconds(1));
		assertEquals(120, ConvertUD.minutesToSeconds(2));
	}

	// Unit test for secondsToMilliseconds
	public void testSecondsToMilliseconds() {
		assertEquals(0L, ConvertUD.secondsToMilliseconds(0));
		assertEquals(1000L, ConvertUD.secondsToMilliseconds(1));
		assertEquals(2000L, ConvertUD.secondsToMilliseconds(2));
	}

	// Unit test for millisecondsToSeconds
	public void testMillisecondsToSeconds() {
		assertEquals(0, ConvertUD.millisecondsToSeconds(0L));
		assertEquals(1, ConvertUD.millisecondsToSeconds(1000L));
		assertEquals(2, ConvertUD.millisecondsToSeconds(2000L));
	}

	// Unit test for convertHashMapToList
	public void testConvertHashMapToList() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);

		List<Map.Entry<String, Integer>> list = ConvertUD.convertHashMapToList(map);

		assertEquals(3, list.size());
		
		assertEquals("one", list.get(0).getKey());
		assertEquals(Integer.valueOf(1), list.get(0).getValue());
		
		assertEquals("two", list.get(1).getKey());
		assertEquals(Integer.valueOf(2), list.get(1).getValue());
		
		assertEquals("three", list.get(2).getKey());
		assertEquals(Integer.valueOf(3), list.get(2).getValue());
	}

	// Unit test for convertListToHashMap
	public void testConvertListToHashMap() {
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		list.add(new AbstractMap.SimpleEntry<>("one", 1));
		list.add(new AbstractMap.SimpleEntry<>("two", 2));
		list.add(new AbstractMap.SimpleEntry<>("three", 3));

		HashMap<String, Integer> map = ConvertUD.convertListToHashMap(list);
		assertEquals(3, map.size());
		assertEquals(Integer.valueOf(1), map.get("one"));
		assertEquals(Integer.valueOf(2), map.get("two"));
		assertEquals(Integer.valueOf(3), map.get("three"));
	}
}
