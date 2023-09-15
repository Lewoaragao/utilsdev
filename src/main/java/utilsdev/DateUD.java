package utilsdev;

import java.util.Calendar;
import java.util.Date;

public class DateUD {
	
	/**
	 * Date Utilities.
	 * @author Leonardo Aragão (@Lewoaragao)
	 * @since 15/09/2023
	 */
	public DateUD() {
	}

	/**
	 * Searches for the first day of the month and year of the parameters.
	 * @param year First parameter required to return the date.
	 * @param month Second parameter required to return the date.
	 * @return Returns date with first day of the month and year of the parameters.
	 */
	public static Date getDateWithFirstDayOfMonth(int year, int month) {
		// Check that the month is in the valid range (1 to 12) and the year is positive.
		if (month < 1 || month > 12 || year < 0) {
			throw new IllegalArgumentException("Mês ou ano inválidos");
		}

		// Create a Calendar object and configure the year and month.
		Calendar calendar = Calendar.getInstance();
		calendar.clear(); // Clear all fields to avoid surprises.
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // Remember that the month starts at 0 (January).

		// Set the day to 1 to get the first day of the month.
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		// Convert the Calendar back to a Date object.
		Date dateWithFirstDayOfMonth = calendar.getTime();

		return dateWithFirstDayOfMonth;
	}

	/**
	 * Searches for the last day of the month and year of the parameters.
	 * @param year First parameter required to return the date.
	 * @param month Second parameter required to return the date.
	 * @return Returns date with last day of the month and year of the parameters.
	 */
	public static Date getDateWithLastDayOfMonth(int year, int month) {
		// Verify that the month is in the valid range (1 to 12) and the year is positive.
		if (month < 1 || month > 12 || year < 0) {
			throw new IllegalArgumentException("Mês ou ano inválidos");
		}

		// Create a Calendar object and configure the year and month.
		Calendar calendar = Calendar.getInstance();
		calendar.clear(); // Clear all fields to avoid surprises.
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // Remember that the month starts at 0 (January).

		// Set the day to the last day of the month.
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		// Convert the Calendar back to a Date object.
		Date dateWithLastDayOfMonth = calendar.getTime();

		return dateWithLastDayOfMonth;
	}

}
