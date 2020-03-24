package com.andrea.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "POSTS")
public class PostModel {

	@Id
	private ObjectId id;
	private ObjectId authorId;
	private String title;
	private String body;
}
