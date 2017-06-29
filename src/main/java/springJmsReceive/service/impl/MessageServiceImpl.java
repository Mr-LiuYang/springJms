package springJmsReceive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import springJmsReceive.entity.Message;
import springJmsReceive.service.MessageService;

/**
 * Created by liuyang on 2017/6/27.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JmsOperations jmsOperations;
    @Override
    public void send(Message message) {
        System.out.println("发送消息");
        jmsOperations.convertAndSend(message);
    }

    @Scheduled(fixedRate=5000)
    public void schedule() {
        System.out.println("执行定时任务");
    }
}
