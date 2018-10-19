package com.souyunku.example.springboot.rabbitmq.ack.receiver;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String context, Message message, Channel channel) throws Exception {
        System.out.println("HelloReceiver收到内容: " + context + "，收到时间:" + new Date());
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("HelloReceiver消息接收成功");
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            System.out.println("消息接收失败");
        }

    }

}
