import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class StockBroker {
	public static void main(String[] args) throws Exception{
		Context context = new InitialContext();
		TopicConnectionFactory tcf = 
				(TopicConnectionFactory) context.lookup("/ConnectionFactory");
		TopicConnection conn = tcf.createTopicConnection();
		TopicSession session = 
				conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic stockTopic = (Topic)context.lookup("/topic/Stock");
		TopicSubscriber subscriber = session.createSubscriber(stockTopic);
		subscriber.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				TextMessage tm = (TextMessage)message;
				try {
					System.out.println("Received price: " + tm.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		conn.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
	}
}
