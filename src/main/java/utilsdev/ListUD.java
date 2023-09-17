package utilsdev;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * List Utilities.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 17/09/2023
 */
@SuppressWarnings("unchecked")
public class ListUD {

	/**
	 * List Utilities.
	 * 
	 * @since 17/09/2023
	 */
	public ListUD() {
	}

	/**
	 * Filtra uma lista de objetos genéricos com base nos campos não nulos do
	 * filtro.
	 *
	 * @param list   A lista de objetos a ser filtrada.
	 * @param filter O filtro que determina quais campos não nulos devem ser
	 *               considerados para filtragem.
	 * @param <T>    O tipo genérico dos objetos na lista.
	 * @return Uma lista contendo os objetos que correspondem aos campos não nulos
	 *         do filtro.
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
	 * Remove objetos de uma lista genérica com base em um filtro genérico e retorna
	 * a lista resultante.
	 *
	 * @param list   A lista de objetos da qual os elementos serão removidos.
	 * @param filter O filtro genérico usado para comparar objetos na lista.
	 * @param <T>    O tipo genérico dos objetos na lista.
	 * @return A lista resultante após a remoção dos elementos correspondentes.
	 */
	public static <T> List<T> remove(List<T> list, T filter) {
		if (filter == null) {
			throw new IllegalArgumentException("O filtro não pode ser nulo");
		}

		boolean allFieldsNull = true;

		for (Field field : filter.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object filterValue = field.get(filter);

				if (filterValue != null) {
					allFieldsNull = false;
					break; // Se qualquer campo não for nulo, saia do loop
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		if (allFieldsNull) {
			throw new IllegalArgumentException("Todos os campos do filtro são nulos");
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
	 * Verifica se um objeto corresponde ao filtro com base em seus campos não
	 * nulos.
	 *
	 * @param item   O objeto a ser verificado.
	 * @param filter O filtro que determina quais campos não nulos devem ser
	 *               considerados para correspondência.
	 * @param <T>    O tipo genérico dos objetos.
	 * @return true se o objeto corresponder ao filtro; caso contrário, false.
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

				// Verifica se o campo no filtro é nulo; se for, pula para o próximo campo
				if (filterValue == null) {
					continue;
				}

				// Compara o valor do campo no item com o valor do campo no filtro
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
	 * Ordena uma lista de objetos genéricos com base em um atributo específico da
	 * entidade.
	 *
	 * @param list          A lista de objetos a ser ordenada.
	 * @param attributeName O nome do atributo pelo qual a lista deve ser ordenada.
	 * @param <T>           O tipo genérico dos objetos na lista.
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

}