package utilsdev.utils;

import java.util.List;

public class VerifyUD {

	/**
	 * Checks if the input object is null.
	 * 
	 * @param <T> the type of the input object
	 * @param obj the input object to be checked
	 * @return the input object if it is not null
	 * @throws IllegalArgumentException if the input object is null
	 */
	public static <T> T isNull(T obj) {
		if (obj == null)
			throw new IllegalArgumentException("The input cannot be null");
		return obj;
	}

	/**
	 * Checks if the input list or any of its entries are null.
	 * 
	 * @param <T>  the type of elements in the list
	 * @param list the list to be checked
	 * @return the input list if it and all its entries are not null
	 * @throws IllegalArgumentException if the list or any of its entries are null
	 */
	public static <T> List<T> isNull(List<T> list) {
		if (list == null)
			throw new IllegalArgumentException("The list cannot be null");

		int index = 0;

		for (T t : list) {
			if (t == null)
				throw new IllegalArgumentException("The list entry with index " + index + " is null");
			index++;
		}

		return list;
	}

}
