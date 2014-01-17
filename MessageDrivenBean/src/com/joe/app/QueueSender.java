package com.joe.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueSender {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args)  {
		try{
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory factory=(QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");
			
			QueueConnection conn = factory.createQueueConnection();
			QueueSession session = conn.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			
			//cast to the parent type: Destination
			Destination destination = (Destination)ctx.lookup("queue/joeQueue");
			
			MessageProducer producer = session.createProducer(destination);
			producer.send(session.createTextMessage("hello, big joe"));
			
			//close resources
			session.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
