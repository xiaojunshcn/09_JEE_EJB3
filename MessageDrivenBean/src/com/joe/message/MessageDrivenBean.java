package com.joe.message;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig=
{
	@ActivationConfigProperty(propertyName="destinationType",
		propertyValue="javax.jms.Queue"),
	@ActivationConfigProperty(propertyName="destination",
		propertyValue="queue/joeQueue")
})
public class MessageDrivenBean implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println(msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
