package com.andrea.service;

import com.andrea.dto.PostDto;
import com.andrea.mapper.PostModelToDtoMapper;
import com.andrea.model.PostModel;
import com.andrea.repository.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostRetrievalService implements IPostRetrievalService {

	protected final PostRepository postRepository;

	public PostRetrievalService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<PostDto> getPostListByAuthorId(String authorId) {
		if (authorId == null) {

		}
		List<PostModel> postModelList = postRepository.findByAuthorId(new ObjectId(authorId));
		return PostModelToDtoMapper.mapList(postModelList);
	}
}
