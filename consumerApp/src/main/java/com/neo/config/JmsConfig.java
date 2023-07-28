package com.neo.config;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.ConnectionFactory;
//import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

@Configuration
@EnableAsync
@EnableJms
public class JmsConfig {
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
		jmsListenerContainerFactory.setConcurrency("5-10");
		return jmsListenerContainerFactory;
	}

	/*@Bean(name = "taskExecutor")
	public ExecutorService getMyTaskExecutor() {
		return  Executors.newFixedThreadPool(4);
		
		 

	}*/
	@Bean(name = "taskExecutor")
	public ThreadPoolExecutorFactoryBean getMyTaskExecutor() {
	 ThreadPoolExecutorFactoryBean factoryBean = new ThreadPoolExecutorFactoryBean();
	  factoryBean.setQueueCapacity(5);
	  factoryBean.setCorePoolSize(6);
	  factoryBean.setMaxPoolSize(10);
	  factoryBean.setThreadPriority(6);
	factoryBean.setKeepAliveSeconds(100);
	//factoryBean.setAllowCoreThreadTimeOut(true);
	factoryBean.setDaemon(true);
	  factoryBean.setThreadNamePrefix("taskexecuter || consumer- ");

	  return factoryBean;

}
}