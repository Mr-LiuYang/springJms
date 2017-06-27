package springJmsReceive.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import springJmsReceive.controller.MessageConvertForSys;

/**
 * Created by liuyang on 2017/6/27.
 */
@Configuration
@EnableJms
@PropertySource("classpath:activeMq.properties")
public class ActiveMqConfig {
    @Value("${spring.activeMq.url}")
    private String url;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(url);
        connectionFactory.setMaxThreadPoolSize(10);
        return connectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("spitter.queue");
    }

    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic("spitter.topic");
    }

    @Bean
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory factory) {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(factory);
        pooledConnectionFactory.setMaxConnections(100);
        return pooledConnectionFactory;
    }

    @Bean
    public SingleConnectionFactory singleConnectionFactory(PooledConnectionFactory pooledConnectionFactory) {
        SingleConnectionFactory factory = new SingleConnectionFactory(pooledConnectionFactory);
        return factory;
    }


    @Bean
    public JmsTemplate jmsTemplate(SingleConnectionFactory connectionFactory, ActiveMQQueue activeMQQueue) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestination(activeMQQueue);
        jmsTemplate.setDefaultDestinationName("spitter.queue1");
        jmsTemplate.setMessageConverter(new MessageConvertForSys());
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SingleConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new MessageConvertForSys());
        return factory;
    }

}
