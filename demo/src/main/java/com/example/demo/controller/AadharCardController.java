package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.AadharCard;
import com.example.demo.model.request.AadharCardCreateRequest;
import com.example.demo.model.request.AadharCardUpdateRequest;
import com.example.demo.model.response.AadharCardCreateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AadharCardController {

	@RequestMapping(path = "/v1.0/aadhar-card", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<AadharCardCreateResponse> persistAddharCard(
			@Valid @RequestBody AadharCardCreateRequest request);

	@RequestMapping(path = "/v1.0/aadhar-card/{id}", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<AadharCard> getAadharById(@PathVariable String id);
	
	@RequestMapping(path= "/v1.0/aadhar-card", produces= "application/json", method= RequestMethod.GET)
	public ResponseEntity<List<AadharCard>> getAllAadhar( @PageableDefault(page = 0, value = 10) Pageable pageable);
	
	@RequestMapping(path= "/v1.0/aadhar-card-delete/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteById(@PathVariable String id);
	
	@RequestMapping(path="v1.0/aadhar-card-deleteAll", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllCards();
	
	
	@RequestMapping(path="/v1.0/aadhar-card-updateMobile/{id}", consumes="application/json", produces= "application/json", method= RequestMethod.PUT)
	public ResponseEntity<String> updateMobileNo(@PathVariable String id, @RequestBody AadharCardUpdateRequest updateDetails) throws JsonProcessingException, ParseException; 
}
