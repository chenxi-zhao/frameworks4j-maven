package com.chenxi.rabbitmq.core;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class WorkQueue_Work {
	// 队列名称
	private final static String QUEUE_NAME = "workqueue_persistence";

	public static void main(String[] argv) throws Exception {
		// 区分不同工作进程的输出
		int hashCode = WorkQueue_Work.class.hashCode();

		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		// 声明队列
		boolean durable = true;
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		System.out.println(hashCode + " [*] Waiting for messages. To exit press CTRL+C");

		// 设置最大服务转发消息数量
		// channel.basicQos(1)保证在接收端一个消息没有处理完时不会接收另一个消息，即接收端发送了ack后才会接收下一个消息。
		// 在这种情况下发送端会尝试把消息发送给下一个not busy的接收端。
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);
		QueueingConsumer consumer = new QueueingConsumer(channel);

		// 指定消费队列
		// 不自动会发ack，由channel.basicAck()在消息处理完成后发送消息
		boolean ack = false; // 打开应答机制
		channel.basicConsume(QUEUE_NAME, ack, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());

			System.out.println(hashCode + " [x] Received '" + message + "'");
			doWork(message);
			System.out.println(hashCode + " [x] Done");
			// 消息处理完成，向队列发送ack确认信息，准备接收下一个消息
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

		}

	}

	/**
	 * 每个点耗时1s
	 * 
	 * @param task
	 * @throws InterruptedException
	 */
	private static void doWork(String task) throws InterruptedException {
		for (char ch : task.toCharArray()) {
			if (ch == '.')
				Thread.sleep(1000);
		}
	}

}
