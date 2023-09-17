package utilsdev;

import java.util.Calendar;
import java.util.Date;

/**
 * Date Utilities.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 09/15/2023
 */
public class DateUD {

	/**
	 * Date Utilities.
	 * 
	 * @since 09/15/2023
	 */
	public DateUD() {
	}

	/**
	 * Finds the first day of the month and year based on the provided parameters.
	 * 
	 * @param year  The first required parameter to determine the date.
	 * @param month The second required parameter to determine the date.
	 * @return Returns a date representing the first day of the month and year based
	 *         on the parameters.
	 */
	public static Date getDateWithFirstDayOfMonth(int year, int month) {
		// Check that the month is within the valid range (1 to 12) and the year is
		// non-negative.
		if (month < 1 || month > 12 || year < 0) {
			throw new IllegalArgumentException("Invalid month or year");
		}

		// Create a Calendar object and set the year and month.
		Calendar calendar = Calendar.getInstance();
		calendar.clear(); // Clear all fields to prevent unexpected values.
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // Note that months start at 0 (January).

		// Set the day to 1 to obtain the first day of the month.
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		// Convert the Calendar object back to a Date.
		Date dateWithFirstDayOfMonth = calendar.getTime();

		return dateWithFirstDayOfMonth;
	}

	/**
	 * Finds the last day of the month and year based on the provided parameters.
	 * 
	 * @param year  The first required parameter to determine the date.
	 * @param month The second required parameter to determine the date.
	 * @return Returns a date representing the last day of the month and year based
	 *         on the parameters.
	 */
	public static Date getDateWithLastDayOfMonth(int year, int month) {
		// Verify that the month is within the valid range (1 to 12) and the year is
		// non-negative.
		if (month < 1 || month > 12 || year < 0) {
			throw new IllegalArgumentException("Invalid month or year");
		}

		// Create a Calendar object and set the year and month.
		Calendar calendar = Calendar.getInstance();
		calendar.clear(); // Clear all fields to prevent unexpected values.
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // Note that months start at 0 (January).

		// Set the day to the last day of the month.
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		// Convert the Calendar object back to a Date.
		Date dateWithLastDayOfMonth = calendar.getTime();

		return dateWithLastDayOfMonth;
	}
}
