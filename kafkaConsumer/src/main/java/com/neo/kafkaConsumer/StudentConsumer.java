package com.neo.kafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.neo.model.Student;
@Service
public class StudentConsumer {
	public final Logger logger=LoggerFactory.getLogger(Student.class);
	 @KafkaListener(topics = "first", groupId = "first-group")
	    public void listenStudentData(Student student) {
		 logger.info("student consume successfully: "+ student);
	      
	    }
}
