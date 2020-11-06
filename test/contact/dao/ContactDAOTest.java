package contact.dao;

import static org.junit.jupiter.api.Assertions.*;

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
		Contact contact = new Contact(2, "Bill Gates", "bill.gates@microsoft.com", "Redmon, WA", "1800123456789");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
