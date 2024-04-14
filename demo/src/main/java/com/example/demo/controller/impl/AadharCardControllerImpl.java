package com.example.demo.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.AadharCardController;
import com.example.demo.entity.AadharCard;
import com.example.demo.model.request.AadharCardCreateRequest;
import com.example.demo.model.request.AadharCardUpdateRequest;
import com.example.demo.model.response.AadharCardCreateResponse;
import com.example.demo.service.AadharCardService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class AadharCardControllerImpl implements AadharCardController {

	@Autowired
	private AadharCardService aadharCardService;

	@Override
	public ResponseEntity<AadharCardCreateResponse> persistAddharCard(@Valid AadharCardCreateRequest request) {
		// TODO Auto-generated method stub

		return ResponseEntity.status(HttpStatus.CREATED).body(aadharCardService.persistAadharCard(request));

	}

	@Override
	public ResponseEntity<AadharCard> getAadharById(String id) {

		return ResponseEntity.status(HttpStatus.OK).body(aadharCardService.getAadharById(id));
	}

	@Override
	public ResponseEntity<List<AadharCard>> getAllAadhar(@PageableDefault(page = 0, value = 10) Pageable pageable) {

		return ResponseEntity.status(HttpStatus.OK).body(aadharCardService.getAllAadhar());
	}

	@Override
	public ResponseEntity<String> deleteById(String id) {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aadharCardService.deleteAadharById(id));
	}

	@Override
	public ResponseEntity<String> deleteAllCards() {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aadharCardService.deleteAllCards());
	}

	@Override
	public ResponseEntity<String> updateMobileNo(String id, AadharCardUpdateRequest updateDetails) throws JsonProcessingException, ParseException {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aadharCardService.updateMobileNo(id, updateDetails));
	}
	
	

}
