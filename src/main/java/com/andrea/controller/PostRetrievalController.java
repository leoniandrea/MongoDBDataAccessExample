package com.andrea.controller;

import com.andrea.dto.PostDto;
import com.andrea.service.IPostRetrievalService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRetrievalController implements IPostRetrievalController {

	protected final IPostRetrievalService postRetrievalService;

	public PostRetrievalController(IPostRetrievalService postRetrievalService) {
		this.postRetrievalService = postRetrievalService;
	}

	@GetMapping(value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PostDto> getPostListByAuthorId(@RequestParam(value = "authorId", required = true) String authorId) {
		return postRetrievalService.getPostListByAuthorId(authorId);
	}
}
