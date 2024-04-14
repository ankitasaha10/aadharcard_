package com.example.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9042409817336428387L;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipcode;
	private String latitude;
	private String longitude;
	private String country;
	private String landMark;
	private boolean isPrimary;
}
