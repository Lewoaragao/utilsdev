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
import utilsdev.ConversionUD;

/**
 * ConversionUD class tests.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 14/09/2023
 */
public class ConversionUDTest extends TestCase {

	public void testDateToString() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o método de conversão
		String dateString = ConversionUD.dateToString(date);

		// Verificar se a data convertida está no formato esperado
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.format(date), dateString);
	}

	public void testStringToDate() throws ParseException {
		// String de data de exemplo
		String dateString = "2023-09-14";

		// Chamar o método de conversão
		Date date = ConversionUD.stringToDate(dateString);

		// Verificar se a data convertida corresponde à data de exemplo
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.parse(dateString), date);
	}

	public void testConvertDateToLocalDateTime() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o método de conversão
		LocalDateTime localDateTime = ConversionUD.dateToLocalDateTime(date);

		// Verificar se a data e hora foram convertidas corretamente
		assertNotNull(localDateTime);

		// Converter de volta para Date e verificar se são iguais
		Date convertedDate = ConversionUD.localDateTimeToDate(localDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertLocalDateTimeToDate() {
		// Criar um LocalDateTime de exemplo
		LocalDateTime localDateTime = LocalDateTime.now();

		// Chamar o método de conversão
		Date date = ConversionUD.localDateTimeToDate(localDateTime);

		// Verificar se a data foi convertida corretamente
		assertNotNull(date);

		// Converter de volta para LocalDateTime e verificar se são iguais
		LocalDateTime convertedLocalDateTime = ConversionUD.dateToLocalDateTime(date);
		assertEquals(localDateTime, convertedLocalDateTime);
	}

	public void testConvertDateToDateTime() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o método de conversão
		ZonedDateTime zonedDateTime = ConversionUD.dateToZonedDateTime(date);

		// Verificar se o ZonedDateTime foi criado corretamente
		assertNotNull(zonedDateTime);

		// Converter de volta para Date e verificar se são iguais
		Date convertedDate = ConversionUD.zonedDateTimeToDate(zonedDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertDateTimeToDate() {
		// Criar um ZonedDateTime de exemplo
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());

		// Chamar o método de conversão
		Date date = ConversionUD.zonedDateTimeToDate(zonedDateTime);

		// Verificar se a data foi convertida corretamente
		assertNotNull(date);

		// Converter de volta para ZonedDateTime e verificar se são iguais
		ZonedDateTime convertedZonedDateTime = ConversionUD.dateToZonedDateTime(date);
		assertEquals(zonedDateTime, convertedZonedDateTime);
	}

	// Teste unitário para integerToString
	public void testIntegerToString() {
		assertEquals("10", ConversionUD.integerToString(10));
		assertEquals("0", ConversionUD.integerToString(0));
		assertEquals("-5", ConversionUD.integerToString(-5));
	}

	// Teste unitário para stringToInteger
	public void testStringToInteger() {
		assertEquals(Integer.valueOf(10), ConversionUD.stringToInteger("10"));
		assertEquals(Integer.valueOf(0), ConversionUD.stringToInteger("0"));
		assertEquals(Integer.valueOf(-5), ConversionUD.stringToInteger("-5"));
	}

	// Teste unitário para stringToInteger com exceção esperada
	public void testStringToIntegerWithException() {
		try {
			ConversionUD.stringToInteger("abc"); // Isso deve lançar NumberFormatException
			fail("Uma exceção NumberFormatException deve ser lançada.");
		} catch (NumberFormatException e) {
			// Exceção esperada
		}
	}

	// Teste unitário para intToString
	public void testIntToString() {
		assertEquals("10", ConversionUD.intToString(10));
		assertEquals("0", ConversionUD.intToString(0));
		assertEquals("-5", ConversionUD.intToString(-5));
	}

	// Teste unitário para stringToInt
	public void testStringToInt() {
		assertEquals(10, ConversionUD.stringToInt("10"));
		assertEquals(0, ConversionUD.stringToInt("0"));
		assertEquals(-5, ConversionUD.stringToInt("-5"));
	}

	// Teste unitário para stringToInt com exceção esperada
	public void testStringToIntWithException() {
		try {
			ConversionUD.stringToInt("abc"); // Isso deve lançar NumberFormatException
			fail("Uma exceção NumberFormatException deve ser lançada.");
		} catch (NumberFormatException e) {
			// Exceção esperada
		}
	}

	// Teste unitário para celsiusToFahrenheit
	public void testCelsiusToFahrenheit() {
		assertEquals(32.0, ConversionUD.celsiusToFahrenheit(0.0));
		assertEquals(68.0, ConversionUD.celsiusToFahrenheit(20.0));
		assertEquals(212.0, ConversionUD.celsiusToFahrenheit(100.0));
	}

	// Teste unitário para fahrenheitToCelsius
	public void testFahrenheitToCelsius() {
		assertEquals(0.0, ConversionUD.fahrenheitToCelsius(32.0));
		assertEquals(20.0, ConversionUD.fahrenheitToCelsius(68.0));
		assertEquals(100.0, ConversionUD.fahrenheitToCelsius(212.0));
	}

	// Teste unitário para hoursToMinutes
	public void testHoursToMinutes() {
		assertEquals(0, ConversionUD.hoursToMinutes(0));
		assertEquals(60, ConversionUD.hoursToMinutes(1));
		assertEquals(120, ConversionUD.hoursToMinutes(2));
	}

	// Teste unitário para minutesToHours
	public void testMinutesToHours() {
		assertEquals(0, ConversionUD.minutesToHours(0));
		assertEquals(1, ConversionUD.minutesToHours(60));
		assertEquals(2, ConversionUD.minutesToHours(120));
	}

	// Teste unitário para hoursToMilliseconds
	public void testHoursToMilliseconds() {
		assertEquals(0L, ConversionUD.hoursToMilliseconds(0));
		assertEquals(3600000L, ConversionUD.hoursToMilliseconds(1));
		assertEquals(7200000L, ConversionUD.hoursToMilliseconds(2));
	}

	// Teste unitário para millisecondsToHours
	public void testMillisecondsToHours() {
		assertEquals(0, ConversionUD.millisecondsToHours(0L));
		assertEquals(1, ConversionUD.millisecondsToHours(3600000L));
		assertEquals(2, ConversionUD.millisecondsToHours(7200000L));
	}

	// Teste unitário para minutesToMilliseconds
	public void testMinutesToMilliseconds() {
		assertEquals(0L, ConversionUD.minutesToMilliseconds(0));
		assertEquals(60000L, ConversionUD.minutesToMilliseconds(1));
		assertEquals(120000L, ConversionUD.minutesToMilliseconds(2));
	}

	// Teste unitário para millisecondsToMinutes
	public void testMillisecondsToMinutes() {
		assertEquals(0, ConversionUD.millisecondsToMinutes(0L));
		assertEquals(1, ConversionUD.millisecondsToMinutes(60000L));
		assertEquals(2, ConversionUD.millisecondsToMinutes(120000L));
	}

	// Teste unitário para hoursToSeconds
	public void testHoursToSeconds() {
		assertEquals(0, ConversionUD.hoursToSeconds(0));
		assertEquals(3600, ConversionUD.hoursToSeconds(1));
		assertEquals(7200, ConversionUD.hoursToSeconds(2));
	}

	// Teste unitário para secondsToHours
	public void testSecondsToHours() {
		assertEquals(0, ConversionUD.secondsToHours(0));
		assertEquals(1, ConversionUD.secondsToHours(3600));
		assertEquals(2, ConversionUD.secondsToHours(7200));
	}

	// Teste unitário para secondsToMinutes
	public void testSecondsToMinutes() {
		assertEquals(0, ConversionUD.secondsToMinutes(0));
		assertEquals(1, ConversionUD.secondsToMinutes(60));
		assertEquals(2, ConversionUD.secondsToMinutes(120));
	}

	// Teste unitário para minutesToSeconds
	public void testMinutesToSeconds() {
		assertEquals(0, ConversionUD.minutesToSeconds(0));
		assertEquals(60, ConversionUD.minutesToSeconds(1));
		assertEquals(120, ConversionUD.minutesToSeconds(2));
	}

	// Teste unitário para secondsToMilliseconds
	public void testSecondsToMilliseconds() {
		assertEquals(0L, ConversionUD.secondsToMilliseconds(0));
		assertEquals(1000L, ConversionUD.secondsToMilliseconds(1));
		assertEquals(2000L, ConversionUD.secondsToMilliseconds(2));
	}

	// Teste unitário para millisecondsToSeconds
	public void testMillisecondsToSeconds() {
		assertEquals(0, ConversionUD.millisecondsToSeconds(0L));
		assertEquals(1, ConversionUD.millisecondsToSeconds(1000L));
		assertEquals(2, ConversionUD.millisecondsToSeconds(2000L));
	}

	// Teste unitário para convertHashMapToList
	public void testConvertHashMapToList() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("um", 1);
		map.put("dois", 2);
		map.put("três", 3);

		List<Map.Entry<String, Integer>> list = ConversionUD.convertHashMapToList(map);
		assertEquals(3, list.size());
		assertEquals("três", list.get(0).getKey());
		assertEquals(Integer.valueOf(3), list.get(0).getValue());
		assertEquals("um", list.get(1).getKey());
		assertEquals(Integer.valueOf(1), list.get(1).getValue());
		assertEquals("dois", list.get(2).getKey());
		assertEquals(Integer.valueOf(2), list.get(2).getValue());
	}

	// Teste unitário para convertListToHashMap
	public void testConvertListToHashMap() {
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		list.add(new AbstractMap.SimpleEntry<>("um", 1));
		list.add(new AbstractMap.SimpleEntry<>("dois", 2));
		list.add(new AbstractMap.SimpleEntry<>("três", 3));

		HashMap<String, Integer> map = ConversionUD.convertListToHashMap(list);
		assertEquals(3, map.size());
		assertEquals(Integer.valueOf(1), map.get("um"));
		assertEquals(Integer.valueOf(2), map.get("dois"));
		assertEquals(Integer.valueOf(3), map.get("três"));
	}

}