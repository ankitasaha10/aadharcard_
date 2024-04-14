package com.example.demo.config.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AadharCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaProducer {

	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper objectMapper;

	 public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
	        this.kafkaTemplate = kafkaTemplate;
	        this.objectMapper = objectMapper;
	    }
	
	 public void sendAadharDetails(AadharCard aadharCard) {
	        try {
	            String jsonAadharCard = objectMapper.writeValueAsString(aadharCard);
	            kafkaTemplate.send("aadhar-details-topic", jsonAadharCard);
	        } catch (JsonProcessingException e) {
	        	 System.out.println("Failed to serialize Aadhar card details");
	            e.printStackTrace();
	        }
}


}
