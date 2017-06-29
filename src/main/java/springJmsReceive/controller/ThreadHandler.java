package springJmsReceive.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by liuyang on 2017/6/29.
 */
@Component
public class ThreadHandler {
    @Async
    public void sout(int i){
        System.out.println("方法一   "+i);
    }
    @Async
    public void sout1(int i){
        System.out.println("方法二   "+i);
    }
}
