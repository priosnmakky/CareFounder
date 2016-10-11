package com.care.health.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Adress")
public class Address {
	@Id
	String id;
	

}
