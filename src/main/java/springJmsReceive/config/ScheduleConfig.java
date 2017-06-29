package springJmsReceive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by liuyang on 2017/6/29.
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages="springJmsReceive")
public class ScheduleConfig {
}
