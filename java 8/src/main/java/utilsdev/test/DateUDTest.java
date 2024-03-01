package utilsdev.test;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import utilsdev.utils.DateUD;

/**
 * DateUD class tests.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 09/15/2023
 */
public class DateUDTest extends TestCase {

	public void testGetDateWithFirstDayOfMonth() {
		// Test for January 2023
		Date date = DateUD.getDateWithFirstDayOfMonth(2023, 1);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		assertEquals(2023, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void testGetDateWithLastDayOfMonth() {
		// Test for December 2023
		Date date = DateUD.getDateWithLastDayOfMonth(2023, 12);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		assertEquals(2023, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.DECEMBER, calendar.get(Calendar.MONTH));
		assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void testGetDateWithInvalidMonth() {
		try {
			DateUD.getDateWithFirstDayOfMonth(2023, 13);
			fail("IllegalArgumentException should be thrown for an invalid month.");
		} catch (IllegalArgumentException e) {
			// Expected exception
		}
	}

	public void testGetDateWithNegativeYear() {
		try {
			DateUD.getDateWithLastDayOfMonth(-2023, 12);
			fail("IllegalArgumentException should be thrown for a negative year.");
		} catch (IllegalArgumentException e) {
			// Expected exception
		}
	}

}
