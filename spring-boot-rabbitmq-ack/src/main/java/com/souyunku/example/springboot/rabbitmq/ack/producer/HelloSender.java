package com.souyunku.example.springboot.rabbitmq.ack.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String context) {
        System.out.println("HelloReceiver发送内容: " + context + "，发送时间:" + new Date());

        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("sendMessage 发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("sendMessage 发送成功 ");
            }
        });
        this.rabbitTemplate.convertAndSend("hello", context);
    }


    /**
     * 失败后返回消息回调
     *
     * @param message    消息返回的消息
     * @param replyCode  回复代码
     * @param replyText  回复文本
     * @param exchange   交换交换
     * @param routingKey 路由密钥
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
    }


}
