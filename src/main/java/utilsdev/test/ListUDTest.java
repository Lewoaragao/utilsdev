package utilsdev.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import utilsdev.ListUD;
import utilsdev.test.model.Entity;

/**
 * ListUD class tests.
 * 
 * @author Leonardo Aragão (@Lewoaragao)
 * @since 17/09/2023
 */
public class ListUDTest extends TestCase {

	// Teste unitário para filter
	public void testFilter() {
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(1, "Nome1", "Descrição1"));
		list.add(new Entity(2, "Nome2", "Descrição2"));
		list.add(new Entity(3, "Nome3", "Descrição3"));
		list.add(new Entity(1, "Nome4", "Descrição4"));

		Entity filter1 = new Entity(1, null, null);
		List<Entity> filteredList1 = ListUD.filter(list, filter1);
		assertEquals(2, filteredList1.size());
		assertEquals(list.get(0), filteredList1.get(0));
		assertEquals(list.get(3), filteredList1.get(1));

		Entity filter2 = new Entity(1, "Nome1", null);
		List<Entity> filteredList2 = ListUD.filter(list, filter2);
		assertEquals(1, filteredList2.size());
		assertEquals(list.get(0), filteredList2.get(0));

		Entity filter3 = new Entity(2, "Nome2", "Descrição2");
		List<Entity> filteredList3 = ListUD.filter(list, filter3);
		assertEquals(1, filteredList3.size());
		assertEquals(list.get(1), filteredList3.get(0));

		Entity filter4 = new Entity(4, null, null);
		List<Entity> filteredList4 = ListUD.filter(list, filter4);
		assertEquals(0, filteredList4.size());
	}

	// Teste unitário para sortByAttribute
	public void testSortByAttribute() {
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(3, "C", "Concentração"));
		list.add(new Entity(1, "A", "Amor"));
		list.add(new Entity(2, "B", "Beijo"));

		ListUD.sortByAttribute(list, "id");
		assertEquals(1, list.get(0).getId());
		assertEquals(2, list.get(1).getId());
		assertEquals(3, list.get(2).getId());

		ListUD.sortByAttribute(list, "name");
		assertEquals("A", list.get(0).getName());
		assertEquals("B", list.get(1).getName());
		assertEquals("C", list.get(2).getName());
	}

	// Teste unitário para ListUD.remove
	public void testRemove() {
		// Cria uma lista de entidades de exemplo
		List<Entity> list = new ArrayList<>();
		list.add(new Entity(1, "A", "Amor"));
		list.add(new Entity(2, "B", "Beijo"));
		list.add(new Entity(3, "C", "Carro"));
		list.add(new Entity(4, "D", "Dado"));

		List<Entity> list1 = new ArrayList<>(list);
		List<Entity> list2 = new ArrayList<>(list);
		List<Entity> list3 = new ArrayList<>(list);
		List<Entity> list4 = new ArrayList<>(list);

		// Cria um filtro com todos os campos nulos
		Entity filterNull = new Entity();

		// Testa a exceção quando o filtro é nulo
		try {
			ListUD.remove(list, null);
			fail("Deveria lançar uma exceção quando o filtro é nulo");
		} catch (IllegalArgumentException e) {
			assertEquals("O filtro não pode ser nulo", e.getMessage());
		}

		// Testa a exceção quando todos os campos do filtro são nulos
		try {
			ListUD.remove(list, filterNull);
			fail("Deveria lançar uma exceção quando todos os campos do filtro são nulos");
		} catch (IllegalArgumentException e) {
			assertEquals("Todos os campos do filtro são nulos", e.getMessage());
		}

		// Cria um filtro com o campo "name" igual a "B"
		Entity filterName = new Entity("B");

		// Remove itens da lista com base no filtro
		List<Entity> resultName = ListUD.remove(list1, filterName);

		// Verifica se a lista resultante está correta
		assertEquals(3, resultName.size());
		assertEquals(1, resultName.get(0).getId());
		assertEquals(3, resultName.get(1).getId());
		assertEquals(4, resultName.get(2).getId());

		// Cria um filtro com o campo "id" igual a 1
		Entity filterId = new Entity(1);

		// Remove itens da lista com base no filtro
		List<Entity> resultId = ListUD.remove(list2, filterId);

		// Verifica se a lista resultante está correta
		assertEquals(3, resultId.size());
		assertEquals(2, resultId.get(0).getId());
		assertEquals(3, resultId.get(1).getId());
		assertEquals(4, resultId.get(2).getId());

		// Cria um filtro com o campo "id" igual a 2 e o campo "name" igual a "B"
		Entity filterIdName = new Entity(2, "B");

		// Remove itens da lista com base no filtro
		List<Entity> resultIdName = ListUD.remove(list3, filterIdName);

		// Verifica se a lista resultante está correta
		assertEquals(3, resultIdName.size());
		assertEquals(1, resultIdName.get(0).getId());
		assertEquals(3, resultIdName.get(1).getId());
		assertEquals(4, resultIdName.get(2).getId());

		// Cria um filtro com o campo "id" igual a 2, "name" igual a "B" e "description"
		// igual a "Beijo"
		Entity filterIdNameDescription = new Entity(2, "B", "Bota");

		// Remove itens da lista com base no filtro
		List<Entity> resultIdNameDescription = ListUD.remove(list4, filterIdNameDescription);

		// Verifica se a lista resultante está correta
		assertEquals(4, resultIdNameDescription.size());
		assertEquals(1, resultIdNameDescription.get(0).getId());
		assertEquals(2, resultIdNameDescription.get(1).getId());
		assertEquals(3, resultIdNameDescription.get(2).getId());
		assertEquals(4, resultIdNameDescription.get(3).getId());
	}

}
