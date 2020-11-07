package contact.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import contact.model.Contact;

class ContactDAOTest {

	private DriverManagerDataSource dataSource;
	private ContactDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		dao = new ContactDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Contact contact = new Contact("Bill Gates", "bill@microsoft.com", "Redmon, WA", "1800123456789");
		int result = dao.save(contact);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(3, "Bill Gates", "bill.gates@microsoft.com", "Redmon, WA", "1800123456789");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		if (contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 8;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listContacts = dao.list();
		for (Contact contact : listContacts) {
			System.out.println(contact);
		}
		assertTrue(!listContacts.isEmpty());
	}

}
