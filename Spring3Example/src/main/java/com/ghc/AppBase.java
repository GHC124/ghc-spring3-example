/**
 * AppBase.java
 *
 *	
 */
package com.ghc;

import org.springframework.context.ApplicationContext;

/**
 * 
 */
public interface AppBase {
	void execute(String[] args, ApplicationContext ctx);
}
