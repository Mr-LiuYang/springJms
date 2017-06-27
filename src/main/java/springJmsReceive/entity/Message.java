package springJmsReceive.entity;

import java.io.Serializable;

/**
 * Created by liuyang on 2017/6/27.
 */
public class Message{
    private String messageName;
    private String messageBody;

    public Message() {
    }

    public Message(String messageName, String messageBody) {
        this.messageName = messageName;
        this.messageBody = messageBody;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageName='" + messageName + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
