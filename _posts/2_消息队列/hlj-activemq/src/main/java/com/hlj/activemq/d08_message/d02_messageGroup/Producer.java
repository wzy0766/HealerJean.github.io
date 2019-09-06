package com.hlj.activemq.d08_message.d02_messageGroup;

import com.hlj.activemq.constants.ActiveMqConstant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Producer {

    /**
     * 队列的名称
     */
    public static final String QUEUE_NAME = "FirstQueue";
    /**
     * 发送消息的数量
     */
    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMqConstant.USERNAME,
                ActiveMqConstant.PASSWORD,
                ActiveMqConstant.BROKER_URL);
        try {
            // 构造从工厂得到连接对象
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // 获取操作连接,一个发送或接收消息的线程
            Session session = connection.createSession(
                    Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);

            // 消息的目的地;消息发送给谁.
            Destination destination = session.createQueue(QUEUE_NAME);

            // 根据目的地获取一个生产者
            MessageProducer producer = session.createProducer(destination);

            //构造消息
            sendGroupMessage(session, producer);


            session.commit();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sendGroupMessage(Session session, MessageProducer producer) throws JMSException {
        for (int i = 1; i <= SEND_NUMBER; i++) {
            TextMessage message = session.createTextMessage("groupA--" + i);
            // message.setStringProperty("JMSXGroupID", "GroupA");
            producer.send(message);

            // TextMessage message2 = session.createTextMessage("groupB--" + i);
            // message2.setStringProperty("JMSXGroupID", "GroupB");
            // producer.send(message2);
        }
    }


}
