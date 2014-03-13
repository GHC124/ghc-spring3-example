/**
 * JdbcContactDAOImpl.java
 * Feb 18, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ghc.jdbc.Contact;
import com.ghc.jdbc.ContactTelDetail;

/**
 * @author ChungPV1
 * 
 */
public class JdbcContactDAOImpl implements ContactDAO, InitializingBean {
	private DataSource mDataSource;
	private JdbcTemplate mJdbcTemplate = new JdbcTemplate();
	private InsertContact mInsertContact;
	private ContactGetFirstName mGetFirstName;
	
	public DataSource getDataSource() {
		return mDataSource;
	}

	public void setDataSource(DataSource dataSource) {
		mDataSource = dataSource;
		mJdbcTemplate.setDataSource(mDataSource);

		mInsertContact = new InsertContact(dataSource);
		mGetFirstName = new ContactGetFirstName(dataSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		if (mDataSource == null) {
			throw new BeanCreationException("Data Source must not null!");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.springjdbc.ContactDAO#findAll()
	 */
	@Override
	public List<Contact> findAll() {
		String sql = "select id, first_name, last_name, birth_date from contact";

		return mJdbcTemplate.query(sql, new ContactMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.springjdbc.ContactDAO#findAllWithDetail()
	 */
	@Override
	public List<Contact> findAllWithDetail() {
		String sql = "select c.id, c.first_name, c.last_name, c.birth_date"
				+ ", t.id as contact_tel_id, t.tel_type, t.tel_number from contact c "
				+ "left join contact_tel_detail t on c.id = t.contact_id";

		return mJdbcTemplate.query(sql, new ContactWithDetailMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.springjdbc.ContactDAO#insert(com.ghc.jdbc.Contact)
	 */
	@Override
	public void insert(Contact contact) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		mInsertContact.updateByNamedParam(paramMap, keyHolder);
		contact.setId(keyHolder.getKey().longValue());
	}	

	/* (non-Javadoc)
	 * @see com.ghc.springjdbc.ContactDAO#getFirstNameById(long)
	 */
	@Override
	public String getFirstNameById(long id) {
		List<String> result = mGetFirstName.execute(id);
		return result.get(0);
	}

	private static final class ContactMapper implements RowMapper<Contact> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}

	}

	private static final class ContactWithDetailMapper implements
			ResultSetExtractor<List<Contact>> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.ResultSetExtractor#extractData(java
		 * .sql.ResultSet)
		 */
		@Override
		public List<Contact> extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Map<Long, Contact> map = new HashMap<>();

			Contact contact = null;
			while (rs.next()) {
				Long id = rs.getLong("id");
				contact = map.get(id);
				if (contact == null) { // new contact record
					contact = new Contact();
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					map.put(id, contact);
				}
				// Process contact tel. detail (if exists)
				Long contactTelDetailId = rs.getLong("contact_tel_id");
				if (contactTelDetailId > 0) {
					ContactTelDetail contactTelDetail = new ContactTelDetail();
					contactTelDetail.setId(contactTelDetailId);
					contactTelDetail.setContactId(id);
					contactTelDetail.setTelType(rs.getString("tel_type"));
					contactTelDetail.setTelNumber(rs.getString("tel_number"));
					contact.getContactTelDetails().add(contactTelDetail);
				}
			}

			return new ArrayList<Contact>(map.values());
		}

	}
}
