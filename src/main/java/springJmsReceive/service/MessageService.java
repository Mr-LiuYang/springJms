package springJmsReceive.service;

import springJmsReceive.entity.Message;

/**
 * Created by liuyang on 2017/6/27.
 */
public interface MessageService {
    void send(Message message);
}
