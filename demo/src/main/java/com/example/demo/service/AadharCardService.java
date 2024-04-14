package com.example.demo.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AadharCard;
import com.example.demo.model.request.AadharCardCreateRequest;
import com.example.demo.model.request.AadharCardUpdateRequest;
import com.example.demo.model.response.AadharCardCreateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public interface AadharCardService {

	public AadharCardCreateResponse persistAadharCard(AadharCardCreateRequest request);
	
	public AadharCard getAadharById(String id);
	
	public List<AadharCard> getAllAadhar();
	
	public String deleteAadharById(String id);
	
	public String deleteAllCards();
	
	public String updateMobileNo(String id, AadharCardUpdateRequest updateDetails) throws JsonProcessingException, ParseException; 
}
