/**
 * ContactMapper.java
 *
 *	
 */
package com.ghc.mybatis.persistence;

import java.util.List;

import com.ghc.mybatis.domain.Contact;

/**
 * 
 */
public interface ContactMapper {
	List<Contact> findAll();;
}
