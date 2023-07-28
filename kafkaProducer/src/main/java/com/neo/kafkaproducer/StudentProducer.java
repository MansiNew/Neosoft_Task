package com.neo.kafkaproducer;


import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.neo.model.Student;


@Service
public class StudentProducer {
KafkaTemplate<String,Student> kafkaTemplate;
//public static final String topic="first";
public final Logger logger=LoggerFactory.getLogger(Student.class);
public StudentProducer(KafkaTemplate<String, Student> kafkaTemplate) {
	super();
	this.kafkaTemplate = kafkaTemplate;
}

public void publishStudentToTopic(Student student) {
	System.out.println("hello");

Message<Student> studentMessage=MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC,"first").build();
	kafkaTemplate.send( studentMessage);
	logger.info("student produce successfully: "+ student);
}

}
