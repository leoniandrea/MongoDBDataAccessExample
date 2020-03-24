package com.andrea.service;

import com.andrea.dto.PostDto;

import java.util.List;

public interface IPostRetrievalService {
	public List<PostDto> getPostListByAuthorId(String authorId);
}
