/**
 * InsertContact.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.springjdbc;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * @author ChungPV1
 *
 */
public class InsertContact extends SqlUpdate {
	private static final String SQL_INSERT_CONTACT = "insert into contact(first_name, last_name, birth_date) values(:first_name, :last_name, :birth_date)";
	
	public InsertContact(DataSource dataSource) {
		super(dataSource, SQL_INSERT_CONTACT);
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", Types.DATE));
		super.setGeneratedKeysColumnNames(new String[] {"id"});
		super.setReturnGeneratedKeys(true);
	}
}
