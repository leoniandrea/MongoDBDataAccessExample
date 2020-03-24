package com.andrea.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "AUTHORS")
public class AuthorModel {
	@Id
	private ObjectId id;
	private String name;
	private String surname;
}
