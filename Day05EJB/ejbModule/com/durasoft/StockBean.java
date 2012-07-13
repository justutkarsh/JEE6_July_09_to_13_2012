package com.durasoft;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
						propertyName = "destinationType", 
						propertyValue = "javax.jms.Topic"),
				@ActivationConfigProperty(
						propertyName = "destination",
						propertyValue = "/topic/Stock")		
		})
public class StockBean implements MessageListener {
    public void onMessage(Message message) {
    	if(message instanceof TextMessage){
    		TextMessage tm = (TextMessage)message;
    		try {
				System.out.println("Received " + tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
    	}
    }
}
