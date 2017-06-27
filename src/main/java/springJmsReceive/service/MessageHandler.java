package springJmsReceive.service;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * Created by liuyang on 2017/6/27.
 */
@Component
public class MessageHandler{
    @Autowired
    private JmsOperations jmsOperations;

    @JmsListener(destination = "spitter.queue")
    public void messageHandler(Message message ) {
        System.out.println(message);
    }

}
