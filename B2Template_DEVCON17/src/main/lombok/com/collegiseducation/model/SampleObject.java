package com.collegiseducation.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class SampleObject {
	private String firstname;
	private String lastname;
	private Integer age;
	
	// Note - This will not be injected if you use the @builder methods to create the object, or if you manually instantiate the object
	// it will only be injected if the class is autowired
	@Value("${properties.test}")
	private String propertiesFileTest;

	public SampleObject(){
		
	}

	@Builder
	public SampleObject(String firstname, String lastname, Integer age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	
}
