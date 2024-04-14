package com.example.demo.config.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AadharCard;
import com.example.demo.repository.AadharCardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaConsumer {
	
	@Autowired
	private AadharCardRepository aadharCardRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	@KafkaListener(topics= "firstTopic", groupId= "aadhar-details-consumer-group")
	public void listen(ConsumerRecord<String, String> record) {
		try {
            String jsonString = record.value();
            AadharCard aadharCard = objectMapper.readValue(jsonString, AadharCard.class);
            
            // Save Aadhar card details to MongoDB
            aadharCardRepository.save(aadharCard);

            System.out.println("Received and persisted Aadhar card details: " + aadharCard.toString());
        } catch (Exception e) {
            // Handle deserialization error
            e.printStackTrace();
	       
	}

}
}
