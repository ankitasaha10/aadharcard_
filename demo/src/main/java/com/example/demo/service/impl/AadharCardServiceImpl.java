package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.config.kafka.producer.KafkaProducer;
import com.example.demo.entity.AadharCard;
import com.example.demo.model.request.AadharCardCreateRequest;
import com.example.demo.model.request.AadharCardUpdateRequest;
import com.example.demo.model.response.AadharCardCreateResponse;
import com.example.demo.repository.AadharCardRepository;
import com.example.demo.service.AadharCardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AadharCardServiceImpl implements AadharCardService {

	@Autowired
	private AadharCardRepository aadharCardRepository;
	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public AadharCardCreateResponse persistAadharCard(AadharCardCreateRequest request) {

		AadharCard aadharCard = new AadharCard();

		aadharCard.setAadharNo(UUID.randomUUID().toString());
		aadharCard.setCreationDate(new Date());

		aadharCardRepository.save(aadharCard);

		kafkaProducer.sendAadharDetails(aadharCard);
		
		AadharCardCreateResponse response = new AadharCardCreateResponse();
		response.setAadharNumber(aadharCard.getAadharNo());
		response.setMsg("AadharCard Generated");
		return response;

	}

	@Override
	public AadharCard getAadharById(String id) {

		AadharCard aadharCard = aadharCardRepository.findById(id).get();
		return aadharCard;

	}

	@Override
	public List<AadharCard> getAllAadhar() {
		List<AadharCard> aadharCards = new ArrayList<>();
		for (AadharCard aadharCard : aadharCardRepository.findAll()) {
			aadharCards.add(aadharCard);
		}
		return aadharCards;
	}

	@Override
	public String deleteAadharById(String id) {
		aadharCardRepository.deleteById(id);

		return "Selected aadhar has been deleted";
	}

	@Override
	public String deleteAllCards() {
		aadharCardRepository.deleteAll();

		return "Aadhard cards deleted";
	}

	@Override
	public String updateMobileNo(String id, AadharCardUpdateRequest updateDetails) throws JsonProcessingException, ParseException {
		AadharCard aadharCard = aadharCardRepository.findById(id).get();

		JSONObject aadharCardObject = (JSONObject) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(aadharCard));

		JSONObject aadharCardPayloadObject = (JSONObject) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(updateDetails));

		for (Object obj : aadharCardPayloadObject.keySet()) {
			String param = (String) obj;
			aadharCardObject.put(param, aadharCardPayloadObject.get(param));
		}

		aadharCard = new ObjectMapper().readValue(aadharCardObject.toJSONString(), AadharCard.class);
		
		aadharCardRepository.save(aadharCard);

		return "Mobile no updated";
	}



}
