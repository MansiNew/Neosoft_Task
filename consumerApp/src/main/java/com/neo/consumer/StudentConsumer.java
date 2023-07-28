package com.neo.consumer;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hibernate.hql.internal.ast.exec.BasicExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.neo.config.WorkerThread;
import com.neo.model.Student;



@Component
public class StudentConsumer {

	private static final Logger logger=LoggerFactory.getLogger(StudentConsumer.class);

	/*
	 * @JmsListener(destination = "first_queue") public void consumerPersonr(Student
	 * student) { ExecutorService executor = Executors.newFixedThreadPool(5); for
	 * (int i = 0; i < 10; i++) { Runnable worker = new
	 * WorkerThread("threads executed " +"  "+ student); //
	 * executor.execute(worker); executor.submit(worker); }
	 * 
	 * //logger.info("Message Received byConsumer for student {}" +student);
	 * executor.shutdown(); while (!executor.isTerminated()) { }
	 * System.out.println("Finished all threads"); }
	 */
	@JmsListener(destination = "first_queue")
	@Async(value = "taskExecutor")
	public void consumerPerson(Student student) {
		logger.info("Message Received byConsumer for student {}" +student);
		 for (int i = 0; i < 10; i++) {
	            Runnable worker = new WorkerThread("threads executed " +"  "+ student);
	         
	          
	}
}}