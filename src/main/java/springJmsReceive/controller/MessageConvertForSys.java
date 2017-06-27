package springJmsReceive.controller;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created by liuyang on 2017/6/27.
 */
@Component
public class MessageConvertForSys implements MessageConverter {
    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        System.out.println("sendMessage:"+object.toString());
        ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
        msg.setObject((Serializable) object);
        return msg;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        springJmsReceive.entity.Message bus = null;
        if(message instanceof ActiveMQObjectMessage){
            ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) message;
            bus=(springJmsReceive.entity.Message) aMsg.getObject();
        }
        System.out.println(bus);
        return bus;
    }
}
