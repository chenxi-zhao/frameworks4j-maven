package com.chenxi.activemq.core;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息生产者
 * 
 * @author Administrator
 *
 */
public class JMSProducer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL = "failover://tcp://192.168.208.128:61616"; // 默认的连接地址
	private static final int SENDNUM = 10; // 发送的消息数量

	public static void main(String[] args) {

		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 接受或者发送消息的线程
		Destination destination; // 消息的目的地，队列或者主题
		MessageProducer messageProducer; // 消息生产者

		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD,
				JMSProducer.BROKEURL);

		try {
			connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
			connection.start(); // 启动连接
			//创建session，第一个参数表示是否开启事务，第二个是应答模式，
			//AUTO_ACKNOWLEDGE 自动应答  CLIENT_ACKNOWLEDGE客户自己确认，但是一旦确认一个其他的全部确认
			//DUPS_OK_ACKNOWLEDGE 
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("FirstQueue1"); // 创建消息队列
			// destination=session.createTopic("FirstTopic1"); //创建主题
			messageProducer = session.createProducer(destination); // 创建消息生产者
			sendMessage(session, messageProducer); // 发送消息
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param session
	 * @param messageProducer
	 * @throws Exception
	 */
	public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception {
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
			TextMessage message = session.createTextMessage("ActiveMQ 发送的消息" + i);
			System.out.println("发送消息：" + "ActiveMQ 发送的消息" + i);
			messageProducer.send(message);
		}
	}
}
