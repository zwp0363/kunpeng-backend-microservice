package com.zwp.kunpengbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.zwp.kunpengbackendjudgeservice.judge.JudgeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MyMessageConsumer {

    @Resource
    private JudgeService judgeService;

    // 指定程序监听的消息队列和确认机制
    @SneakyThrows // 编译器会自动为你处理受检查异常
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    // 监听名为 "code_queue" 的消息队列。当队列中有消息时，Spring 会自动调用被 @RabbitListener 注解标记的方法，并将消息内容作为参数传入
    // 手动确认消息模式，以通知 RabbitMQ 该消息可以从队列中移除了
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        // deliveryTag 是一个标识符，用于唯一标识一条消息在 RabbitMQ 中的消息标识。使用 @Header 注解从消息头中提取这个值
        log.info("receiveMessage message = {}", message);
        long questionSubmitId = Long.parseLong(message);
        try {
            judgeService.doJudge(questionSubmitId);
            channel.basicAck(deliveryTag, false);
            // 调用 basicAck() 方法确认消息已被成功处理，表示 RabbitMQ 可以删除该消息，deliveryTag 用于指定确认的消息，false 表示只确认这条消息。
        } catch (Exception e) {
            channel.basicNack(deliveryTag, false, false);
            // 调用 basicNack() 方法进行负确认。false 表示只针对这条消息进行操作，最后的 false 表示此消息不会被重新入队（即不希望 RabbitMQ 重新发送这条消息）
        }
    }

}