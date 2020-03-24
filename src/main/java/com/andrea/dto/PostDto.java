package com.andrea.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@EqualsAndHashCode
public class PostDto {
	private String id;
	private String authorId;
	private String title;
	private String body;
}
