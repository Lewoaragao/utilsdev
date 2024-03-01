package utilsdev.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * List Utilities.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 17/09/2023
 */
@SuppressWarnings({ "unchecked", "unused" })
public class CollectionUD {

	/**
	 * List Utilities.
	 * 
	 * @since 17/09/2023
	 */
	public CollectionUD() {
	}

	/**
	 * Filters a list of generic objects based on non-null fields of the filter.
	 *
	 * @param list   The list of objects to be filtered.
	 * @param filter The filter that determines which non-null fields should be
	 *               considered for filtering.
	 * @param <T>    The generic type of objects in the list.
	 * @return A list containing objects that match the non-null fields of the
	 *         filter.
	 */
	public static <T> List<T> filter(List<T> list, T filter) {
		List<T> filteredList = new ArrayList<>();

		for (T item : list) {
			if (matchesFilter(item, filter)) {
				filteredList.add(item);
			}
		}

		return filteredList;
	}

	/**
	 * Removes objects from a generic list based on a generic filter and returns the
	 * resulting list.
	 *
	 * @param list   The list of objects from which elements will be removed.
	 * @param filter The generic filter used to compare objects in the list.
	 * @param <T>    The generic type of objects in the list.
	 * @return The resulting list after removing matching elements.
	 */
	public static <T> List<T> remove(List<T> list, T filter) {
		if (filter == null) {
			throw new IllegalArgumentException("The filter cannot be null");
		}

		boolean allFieldsNull = true;

		for (Field field : filter.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object filterValue = field.get(filter);

				if (filterValue != null) {
					allFieldsNull = false;
					break; // If any field is not null, exit the loop
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		if (allFieldsNull) {
			throw new IllegalArgumentException("All filter fields are null");
		}

		Iterator<T> iterator = list.iterator();

		while (iterator.hasNext()) {
			T item = iterator.next();

			if (matchesFilter(item, filter)) {
				iterator.remove();
			}
		}

		return list;
	}

	/**
	 * Checks if an object matches the filter based on its non-null fields.
	 *
	 * @param item   The object to be checked.
	 * @param filter The filter that determines which non-null fields should be
	 *               considered for matching.
	 * @param <T>    The generic type of objects.
	 * @return true if the object matches the filter; otherwise, false.
	 */
	private static <T> boolean matchesFilter(T item, T filter) {
		if (item == null || filter == null) {
			return false;
		}

		for (Field field : item.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object itemValue = field.get(item);
				Object filterValue = field.get(filter);

				// Check if the field in the filter is null; if so, skip to the next field
				if (filterValue == null) {
					continue;
				}

				// Compare the value of the field in the item with the value of the field in the
				// filter
				if (!filterValue.equals(itemValue)) {
					return false;
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	/**
	 * Sorts a list of generic objects based on a specific attribute of the entity.
	 *
	 * @param list          The list of objects to be sorted.
	 * @param attributeName The name of the attribute by which the list should be
	 *                      sorted.
	 * @param <T>           The generic type of objects in the list.
	 */
	public static <T> void sortByAttribute(List<T> list, String attributeName) {
		Collections.sort(list, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				try {
					Field field = o1.getClass().getDeclaredField(attributeName);
					field.setAccessible(true);
					Comparable<Object> fieldValue1 = (Comparable<Object>) field.get(o1);
					Comparable<Object> fieldValue2 = (Comparable<Object>) field.get(o2);
					return fieldValue1.compareTo(fieldValue2);
				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
					return 0;
				}
			}
		});
	}

	/**
	 * Sorts a HashMap based on the type of keys.
	 *
	 * @param map The HashMap to be sorted.
	 * @param <K> The type of keys in the HashMap.
	 * @param <V> The type of values in the HashMap.
	 * @return A sorted LinkedHashMap based on the type of keys.
	 */
	public static <K, V> LinkedHashMap<K, V> sortByKeyType(HashMap<K, V> map) {
		// Create a list of Map.Entry objects from the HashMap
		List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());

		// Define a custom comparator based on key types
		Comparator<Map.Entry<K, V>> comparator = (entry1, entry2) -> {
			Class<?> keyType1 = entry1.getKey().getClass();
			Class<?> keyType2 = entry2.getKey().getClass();
			return keyType1.getName().compareTo(keyType2.getName());
		};

		// Sort the entryList using the custom comparator
		entryList.sort(comparator);

		// Create a new LinkedHashMap to store the sorted entries
		LinkedHashMap<K, V> sortedMap = new LinkedHashMap<>();

		// Add the sorted entries to the new map
		for (Map.Entry<K, V> entry : entryList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	/**
	 * Sorts a HashMap based on a specified attribute of the values.
	 *
	 * @param <K>       The type of keys in the HashMap.
	 * @param <V>       The type of values in the HashMap.
	 * @param map       The HashMap to be sorted.
	 * @param attribute The name of the attribute to use for sorting.
	 * @param valueType The class type of the values in the HashMap.
	 * @return A sorted LinkedHashMap based on the specified attribute of the
	 *         values.
	 * @throws NoSuchFieldException     If the specified attribute does not exist in
	 *                                  the value class.
	 * @throws IllegalAccessException   If there is an issue accessing the
	 *                                  attribute.
	 * @throws IllegalArgumentException If the attribute is not Comparable or if the
	 *                                  value class is empty.
	 */
	public static <K, V> LinkedHashMap<K, V> sortByValueAttribute(HashMap<K, V> map, String attribute,
			Class<V> valueType) throws NoSuchFieldException, IllegalAccessException {

		V sampleValue = map.values().stream().findAny().orElse(null);

		if (sampleValue == null) {
			throw new IllegalArgumentException("Value class is empty");
		}

		try {
			sampleValue.getClass().getDeclaredField(attribute);
		} catch (NoSuchFieldException e) {
			throw new IllegalArgumentException("Attribute '" + attribute + "' does not exist in the value class");
		}

		try {
			// Create a list of Map.Entry objects from the HashMap
			List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());

			// Define a custom comparator based on the specified attribute of the values
			Comparator<Map.Entry<K, V>> comparator = (entry1, entry2) -> {
				Comparable<Object> attrValue1 = null;
				Comparable<Object> attrValue2 = null;

				try {
					attrValue1 = (Comparable<Object>) getAttributeValue(entry1.getValue(), attribute, valueType);
					attrValue2 = (Comparable<Object>) getAttributeValue(entry2.getValue(), attribute, valueType);
				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}

				// Compare the attribute values
				return attrValue1.compareTo(attrValue2);
			};

			// Sort the entryList using the custom comparator
			entryList.sort(comparator);

			// Create a new LinkedHashMap to store the sorted entries
			LinkedHashMap<K, V> sortedMap = new LinkedHashMap<>();

			// Add the sorted entries to the new map
			for (Map.Entry<K, V> entry : entryList) {
				sortedMap.put(entry.getKey(), entry.getValue());
			}

			return sortedMap;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves the value of a specified attribute from an object and ensures it's
	 * Comparable.
	 *
	 * @param value     The object from which to retrieve the attribute value.
	 * @param attribute The name of the attribute to retrieve.
	 * @param valueType The class type of the object.
	 * @param <V>       The type of values in the HashMap.
	 * @return A Comparable representing the attribute value.
	 * @throws NoSuchFieldException     If the specified attribute does not exist in
	 *                                  the object.
	 * @throws IllegalAccessException   If there is an issue accessing the
	 *                                  attribute.
	 * @throws IllegalArgumentException If the attribute is not Comparable.
	 */
	private static <V> Comparable<?> getAttributeValue(V value, String attribute, Class<V> valueType)
			throws NoSuchFieldException, IllegalAccessException {
		Field field = valueType.getDeclaredField(attribute);
		field.setAccessible(true);
		Object attrValue = field.get(value);

		// Convert the attribute value to a Comparable
		if (attrValue instanceof Comparable) {
			return (Comparable<?>) attrValue;
		} else {
			throw new IllegalArgumentException("Attribute is not Comparable");
		}
	}
}
