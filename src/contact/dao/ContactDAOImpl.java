package contact.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import contact.model.Contact;

public class ContactDAOImpl implements ContactDAO{

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (name, email, address, phone) VALUE (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone());
	}

	@Override
	public int update(Contact c) {
		String sql = "UPDATE Contact SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone(), c.getId());
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
