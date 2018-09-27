package com.sandbox.custom_handler;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.rabbitmq.client.BuiltinExchangeType.FANOUT;

public class RabbitClient {
    private static RabbitClient instance;

    static RabbitClient getInstance() {
        if (instance == null) {
            instance = new RabbitClient();

            String rabbitHost = System.getenv("RABBIT_MQ_HOST");
            int rabbitPort = Integer.parseInt(System.getenv("RABBIT_MQ_PORT"));
            String rabbitUser = System.getenv("RABBIT_MQ_USER");
            String rabbitPassword = System.getenv("RABBIT_MQ_PASSWORD");

            System.out.println("Configuring RabbitMQ connection factory with " + rabbitHost + ":" + rabbitPort);

            instance.connectionFactory = new ConnectionFactory();
            instance.connectionFactory.setHost(rabbitHost);
            instance.connectionFactory.setPort(rabbitPort);
            instance.connectionFactory.setUsername(rabbitUser);
            instance.connectionFactory.setPassword(rabbitPassword);
        }
        return instance;
    }

    private Connection connection;
    private ConnectionFactory connectionFactory;

    private Connection getConnection() throws IOException, TimeoutException {
        if (connection == null || !this.connection.isOpen()) {
            System.out.println("Getting new RabbitMQ connection");
            this.connection = connectionFactory.newConnection();
        }
        return this.connection;
    }

    void sendMessage(String message) throws IOException, TimeoutException {
        Channel channel = getConnection().createChannel();
        String exchangeName = "jbpm_process_events";
        channel.exchangeDeclare(exchangeName, FANOUT, true);
        channel.basicPublish(exchangeName, null, null, message.getBytes());
        System.out.println("[RabbitMQ] Sent '" + message + "'");
        channel.close();
    }

    public void close() throws IOException {
        connection.close();
    }
}
