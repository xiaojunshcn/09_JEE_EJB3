package junit.test;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.joe.bean.Person;
import com.joe.service.IPersonService;

public class IPersonServiceTest {
	private static IPersonService personService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = new InitialContext();
		personService = (IPersonService) ctx.lookup("PersonServiceBean/remote");
	}

	@Test
	public void testSave() {
		personService.save(new Person("big joe"));
	}

	@Test
	public void testUpdate() {
		Person person = personService.getPerson(1);
		person.setName("xxxx");
		personService.update(person);
	}

	@Test
	public void testDelete() {
		personService.delete(1);
	}

	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons() {
		List<Person> persons = personService.getPersons();
		for (Person person:persons) {
			System.out.println(person.getName());
		}
	}

}
