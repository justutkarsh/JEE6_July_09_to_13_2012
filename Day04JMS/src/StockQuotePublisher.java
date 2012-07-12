import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class StockQuotePublisher {
	public static void main(String[] args) throws Exception{
		Context context = new InitialContext();
		TopicConnectionFactory tcf = 
				(TopicConnectionFactory) context.lookup("/ConnectionFactory");
		TopicConnection conn = tcf.createTopicConnection();
		TopicSession session = 
				conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic stockTopic = (Topic)context.lookup("/topic/Stock");
		TopicPublisher publisher = session.createPublisher(stockTopic);
		conn.start();
		while(true){
			double price = Math.random()*3000;
			TextMessage msg = session.createTextMessage();
			msg.setText("Price: Rs." + price);
			publisher.publish(msg);
			System.out.println("Published " + "Price: Rs." + price);
			Thread.sleep(3000);
		}
	}
}
