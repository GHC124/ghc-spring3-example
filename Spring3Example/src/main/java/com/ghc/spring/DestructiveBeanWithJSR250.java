/**
 * DestructiveBeanWithJSR250.java
 * @author ChungPV1 
 *	
 */
package com.ghc.spring;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author ChungPV1
 * 
 */
public class DestructiveBeanWithJSR250 implements BeanNameAware {
	private String mBeanName;		
	
	private String mText;

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		mText = text;
	}

	public void showMessage() {
		System.out.println(mText);
		
		System.out.println(String.format("[%s] %s", mBeanName, mText));
	}
	
	public void init()throws Exception{
		System.out.println("Post construct");
	}
	
	public void destroy()throws Exception{
		System.out.print("Pre destroy");
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		mBeanName = name;
	}
	
}
