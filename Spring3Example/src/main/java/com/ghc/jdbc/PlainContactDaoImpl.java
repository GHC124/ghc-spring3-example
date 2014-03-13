/**
 * PlainContactDaoImpl.java
 * Feb 18, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChungPV1
 * 
 */
public class PlainContactDaoImpl implements ContactDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/spring3example_jdbc", "root", "");
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jdbc.ContactDAO#findAll()
	 */
	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<Contact>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from contact");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirthDate(resultSet.getDate("birth_date"));
				result.add(contact);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jdbc.ContactDAO#findByFirstName(java.lang.String)
	 */
	@Override
	public List<Contact> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jdbc.ContactDAO#insert(com.ghc.jdbc.Contact)
	 */
	@Override
	public void insert(Contact contact) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jdbc.ContactDAO#update(com.ghc.jdbc.Contact)
	 */
	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.jdbc.ContactDAO#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long contactId) {
		// TODO Auto-generated method stub

	}

}
