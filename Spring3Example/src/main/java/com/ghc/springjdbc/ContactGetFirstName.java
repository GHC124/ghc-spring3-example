/**
 * ContactGetFirstName.java
 * Feb 19, 2014	
 * @author ChungPV1 
 *	
 */
package com.ghc.springjdbc;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

/**
 * @author ChungPV1
 * 
 */
public class ContactGetFirstName extends SqlFunction<String> {
	private static final String SQL = "select getFirstNameById(?)";

	public ContactGetFirstName(DataSource dataSource) {
		super(dataSource, SQL);
		declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}

}
