package utilsdev.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import utilsdev.test.model.Entity;
import utilsdev.utils.CollectionUD;

/**
 * Tests for the CollectionUD class.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 17/09/2023
 */
@SuppressWarnings("unused")
public class CollectionUDTest extends TestCase {

	// Unit test for filter
	public void testFilter() {
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(1, "Name1", "Description1"));
		list.add(new Entity(2, "Name2", "Description2"));
		list.add(new Entity(3, "Name3", "Description3"));
		list.add(new Entity(1, "Name4", "Description4"));

		Entity filter1 = new Entity(1, null, null);
		List<Entity> filteredList1 = CollectionUD.filter(list, filter1);
		assertEquals(2, filteredList1.size());
		assertEquals(list.get(0), filteredList1.get(0));
		assertEquals(list.get(3), filteredList1.get(1));

		Entity filter2 = new Entity(1, "Name1", null);
		List<Entity> filteredList2 = CollectionUD.filter(list, filter2);
		assertEquals(1, filteredList2.size());
		assertEquals(list.get(0), filteredList2.get(0));

		Entity filter3 = new Entity(2, "Name2", "Description2");
		List<Entity> filteredList3 = CollectionUD.filter(list, filter3);
		assertEquals(1, filteredList3.size());
		assertEquals(list.get(1), filteredList3.get(0));

		Entity filter4 = new Entity(4, null, null);
		List<Entity> filteredList4 = CollectionUD.filter(list, filter4);
		assertEquals(0, filteredList4.size());
	}

	// Unit test for sortByAttribute
	public void testSortByAttribute() {
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(3, "C", "Concentration"));
		list.add(new Entity(1, "A", "Love"));
		list.add(new Entity(2, "B", "Kiss"));

		CollectionUD.sortByAttribute(list, "id");
		assertEquals(1, list.get(0).getId());
		assertEquals(2, list.get(1).getId());
		assertEquals(3, list.get(2).getId());

		CollectionUD.sortByAttribute(list, "name");
		assertEquals("A", list.get(0).getName());
		assertEquals("B", list.get(1).getName());
		assertEquals("C", list.get(2).getName());
	}

	// Unit test for ListUD.remove
	public void testRemove() {
		// Create a list of example entities
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(1, "A", "Love"));
		list.add(new Entity(2, "B", "Kiss"));
		list.add(new Entity(3, "C", "Car"));
		list.add(new Entity(4, "D", "Dice"));

		List<Entity> list1 = new ArrayList<>(list);
		List<Entity> list2 = new ArrayList<>(list);
		List<Entity> list3 = new ArrayList<>(list);
		List<Entity> list4 = new ArrayList<>(list);

		// Create a filter with all fields null
		Entity filterNull = new Entity();

		// Test the exception when the filter is null
		try {
			CollectionUD.remove(list, null);
			fail("Should throw an exception when the filter is null");
		} catch (IllegalArgumentException e) {
			assertEquals("The filter cannot be null", e.getMessage());
		}

		// Test the exception when all filter fields are null
		try {
			CollectionUD.remove(list, filterNull);
			fail("Should throw an exception when all filter fields are null");
		} catch (IllegalArgumentException e) {
			assertEquals("All filter fields are null", e.getMessage());
		}

		// Create a filter with the "name" field equal to "B"
		Entity filterName = new Entity("B");

		// Remove items from the list based on the filter
		List<Entity> resultName = CollectionUD.remove(list1, filterName);

		// Verify if the resulting list is correct
		assertEquals(3, resultName.size());
		assertEquals(1, resultName.get(0).getId());
		assertEquals(3, resultName.get(1).getId());
		assertEquals(4, resultName.get(2).getId());

		// Create a filter with the "id" field equal to 1
		Entity filterId = new Entity(1);

		// Remove items from the list based on the filter
		List<Entity> resultId = CollectionUD.remove(list2, filterId);

		// Verify if the resulting list is correct
		assertEquals(3, resultId.size());
		assertEquals(2, resultId.get(0).getId());
		assertEquals(3, resultId.get(1).getId());
		assertEquals(4, resultId.get(2).getId());

		// Create a filter with the "id" field equal to 2 and the "name" field equal to
		// "B"
		Entity filterIdName = new Entity(2, "B");

		// Remove items from the list based on the filter
		List<Entity> resultIdName = CollectionUD.remove(list3, filterIdName);

		// Verify if the resulting list is correct
		assertEquals(3, resultIdName.size());
		assertEquals(1, resultIdName.get(0).getId());
		assertEquals(3, resultIdName.get(1).getId());
		assertEquals(4, resultIdName.get(2).getId());

		// Create a filter with the "id" field equal to 2, "name" field equal to "B,"
		// and "description" field equal to "Kiss"
		Entity filterIdNameDescription = new Entity(2, "B", "Boot");

		// Remove items from the list based on the filter
		List<Entity> resultIdNameDescription = CollectionUD.remove(list4, filterIdNameDescription);

		// Verify if the resulting list is correct
		assertEquals(4, resultIdNameDescription.size());
		assertEquals(1, resultIdNameDescription.get(0).getId());
		assertEquals(2, resultIdNameDescription.get(1).getId());
		assertEquals(3, resultIdNameDescription.get(2).getId());
		assertEquals(4, resultIdNameDescription.get(3).getId());
	}

	public void testSortByKeyType() {
		// Create a HashMap with keys of different types (replace with your own data)
		HashMap<String, Integer> stringKeyMap = new HashMap<>();
		stringKeyMap.put("one", 1);
		stringKeyMap.put("two", 2);

		HashMap<Integer, String> intKeyMap = new HashMap<>();
		intKeyMap.put(1, "one");
		intKeyMap.put(2, "two");

		// Sort the HashMap by key type
		LinkedHashMap<String, Integer> sortedStringKeyMap = CollectionUD.sortByKeyType(stringKeyMap);
		LinkedHashMap<Integer, String> sortedIntKeyMap = CollectionUD.sortByKeyType(intKeyMap);

		// Verify the sorted order
		LinkedHashMap<String, Integer> expectedStringKeyMap = new LinkedHashMap<>();
		expectedStringKeyMap.put("one", 1);
		expectedStringKeyMap.put("two", 2);

		LinkedHashMap<Integer, String> expectedIntKeyMap = new LinkedHashMap<>();
		expectedIntKeyMap.put(1, "one");
		expectedIntKeyMap.put(2, "two");

		assertEquals(expectedStringKeyMap, sortedStringKeyMap);
		assertEquals(expectedIntKeyMap, sortedIntKeyMap);
	}

	public void testSortByValueAttribute() {
		// Create an unsorted HashMap
		HashMap<Integer, Entity> unsortedMap = new HashMap<>();
		unsortedMap.put(1, new Entity(1, "Alice", "Description A"));
		unsortedMap.put(2, new Entity(2, "Bob", "Description B"));
		unsortedMap.put(3, new Entity(3, "Charlie", "Description C"));

		try {
			// Sort the HashMap based on the 'name' attribute of Entity objects
			LinkedHashMap<Integer, Entity> sortedMap = CollectionUD.sortByValueAttribute(unsortedMap, "name",
					Entity.class);

			// Check if the values are sorted correctly
			String previousName = "";
			for (Map.Entry<Integer, Entity> entry : sortedMap.entrySet()) {
				String currentName = entry.getValue().getName();
				assertTrue(currentName.compareTo(previousName) >= 0);
				previousName = currentName;
			}
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	public void testSortByValueAttributeWithNonComparableAttribute() {
		// Create an unsorted HashMap with a non-comparable attribute
		HashMap<Integer, Entity> unsortedMap = new HashMap<>();
		unsortedMap.put(1, new Entity(1, "Alice", "Description A"));
		unsortedMap.put(2, new Entity(2, "Bob", "Description B"));
		unsortedMap.put(3, new Entity(3, "Charlie", "Description C"));

		try {
			// Try to sort the HashMap based on the 'dscDescription' attribute of Entity
			// objects
			LinkedHashMap<Integer, Entity> sortedMap = CollectionUD.sortByValueAttribute(unsortedMap,
					"unknownAttribute", Entity.class);

			// The test should fail because 'unknownAttribute' is not comparable
			fail("An IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException e) {
			// Expected exception
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
}
