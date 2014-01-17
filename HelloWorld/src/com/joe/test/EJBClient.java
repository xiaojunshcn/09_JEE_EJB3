package com.joe.test;

import java.util.Properties;

import javax.naming.InitialContext;
import com.joe.ejb3.IHelloWorld;

public class EJBClient {
//	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
//		
//		try{
//			InitialContext ctx = new InitialContext(props);
//			IHelloWorld helloWorld = (IHelloWorld) ctx.lookup("HelloWorldBean/remote");
//			System.out.println(helloWorld.sayHello("Shanghai"));
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public static void main(String[] args) {
		try{
			InitialContext ctx = new InitialContext();
			IHelloWorld helloWorld = (IHelloWorld) ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloWorld.sayHello("Beijing"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
