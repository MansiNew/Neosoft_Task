package com.neo.config;

import javax.jms.ConnectionFactory;
//import javax.jms.Queue;

import org.apache.activemq.broker.region.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class JmsConfig {
	/*@Bean
 public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
	 DefaultJmsListenerContainerFactory jmsListenerContainerFactory=new   DefaultJmsListenerContainerFactory();
	 jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
	 jmsListenerContainerFactory.setConcurrency("5-10");
	 return jmsListenerContainerFactory;
 }
*/
	
}
