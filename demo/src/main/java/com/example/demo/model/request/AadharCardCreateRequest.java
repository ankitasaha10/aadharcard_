package com.example.demo.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.example.demo.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AadharCardCreateRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 190239652902173754L;
	private String name;
	private int age;
	private String fathersName;
	private String motherName;

	@NotEmpty(message = "Mobile number must not be null or empty")
	private String mobile;

	@NotEmpty(message = "Email must not be null or empty")
	private String email;

	@Builder.Default
	private List<Address> address = new ArrayList<Address>();

}
