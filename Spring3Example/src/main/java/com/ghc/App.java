package com.ghc;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ghc.jpa.AppJPA;


public class App {
	public static void main(String[] args){
		App app = new App();
		app.doExecute(args);
	}
	
	public void doExecute(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");		
		ctx.registerShutdownHook();
		ctx.refresh();
		
		System.out.println("///////////////////////////////////////////// Do Execute ///////////////////////////////////////////");
		
		AppBase appBase = new AppJPA();
		appBase.execute(args, ctx);
		
		System.out.println("///////////////////////////////////////////// End Execute ///////////////////////////////////////////");
	}	
}
