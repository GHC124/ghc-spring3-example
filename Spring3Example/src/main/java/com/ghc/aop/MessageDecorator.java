/**
 * MessageDecorator.java
 * @author ChungPV1 
 *	
 */
package com.ghc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ChungPV1
 *
 */
public class MessageDecorator implements MethodInterceptor {

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("ChungPV1");
		Object value = invocation.proceed();
		return value;
		
	}

}
