package com.joe.ejb3.impl;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.joe.ejb3.IHelloWorld;
import com.joe.ejb3.IHelloWorldLocal;
import com.joe.ejb3.IOther;

@Stateful
@Remote(IHelloWorld.class)
@Local(IHelloWorldLocal.class)
public class HelloWorldBean implements IHelloWorld, IHelloWorldLocal {
	@EJB(beanName="OtherBean") IOther other;
	@Resource TimerService timerService;
	@Resource(mappedName="java:yourDataSourceName") DataSource dataSource;
	
	public String sayHello(String name) {
		return name + " says: hello, world!" + other.sayMe() ;
		
//		try{
//			InitialContext ctx = new InitialContext();
//			IOther other = (IOther) ctx.lookup("OtherBean/local");
//			
//			return name + " says: hello, world!" + other.sayMe() ;
//		} catch(NamingException e) {
//			e.printStackTrace();	
//		}
//		return "no calling other";
	}
}