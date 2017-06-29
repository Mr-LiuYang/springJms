package springJmsReceive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by liuyang on 2017/6/29.
 */
@ComponentScan(basePackages="springJmsReceive")
@Component
@EnableAsync
public class ThreadConfig {
}
