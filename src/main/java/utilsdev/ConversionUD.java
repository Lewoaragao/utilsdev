package utilsdev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionUD {

	/**
	 * Conversion utilities.
	 * @author Leonardo Aragão (@Lewoaragao)
	 * @since 14/09/2023
	 */
	public ConversionUD() {
	}

	/**
	 * Date to String Conversion.
	 * @param date Parameter in Date format that will be converted to String.
	 * @return String in the format "yyyy-MM-dd" with "yyyy" being the year, "MM" the month and "dd" the day.
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * String to Date Conversion.
	 * @param dateString Parameter in String format "yyyy-MM-dd", with "yyyy" being the year, "MM" the month and "dd" the day, which will be converted to Date.
	 * @return Date
	 * @throws ParseException Exception if conversion is not possible.
	 */
	public static Date stringToDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateString);
	}
	
}
