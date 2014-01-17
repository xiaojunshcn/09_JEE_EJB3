package com.joe.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class TopicSender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			InitialContext ctx = new InitialContext();
			TopicConnectionFactory factory=(TopicConnectionFactory)ctx.lookup("TopicConnectionFactory");
			
			TopicConnection conn = factory.createTopicConnection();
			TopicSession session = conn.createTopicSession(false,TopicSession.AUTO_ACKNOWLEDGE);
			
			//cast to the parent type: Destination
			Destination destination = (Destination)ctx.lookup("topic/joeTopic");
			
			MessageProducer producer = session.createProducer(destination);
			producer.send(session.createTextMessage("hello, big joe. this is a topic message "));
			
			//close resources
			session.close();
			conn.close();
			System.out.println("topic is sent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
