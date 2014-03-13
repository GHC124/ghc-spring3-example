/**
 * AppProxyFactory.java
 *
 *	
 */
package com.ghc.aop;

import java.util.Locale;

import org.springframework.context.ApplicationContext;

import com.ghc.AppBase;
import com.ghc.spring.DestructiveBeanWithJSR250;

/**
 * 
 */
public class AppAOP implements AppBase {

	/* (non-Javadoc)
	 * @see com.ghc.AppBase#execute(java.lang.String[])
	 */
	@Override
	public void execute(String[] args, ApplicationContext ctx) {		
		DestructiveBeanWithJSR250 jsr250 = (DestructiveBeanWithJSR250)ctx.getBean("destructiveBeanWithJSR250");
		jsr250.showMessage();
		
		jsr250.setText(ctx.getMessage("msg", new String[] {"ChungPV1"} , Locale.ENGLISH));
		jsr250.showMessage();
	}

}
