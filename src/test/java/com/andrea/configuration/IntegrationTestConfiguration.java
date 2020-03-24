package com.andrea.configuration;

import com.andrea.TestUtil;
import com.andrea.model.PostModel;
import com.andrea.repository.PostRepository;
import com.andrea.service.PostRetrievalService;
import org.bson.types.ObjectId;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@TestConfiguration
public class IntegrationTestConfiguration {

	@Autowired
	PostRepository postRepository2;

	@Primary
	@Bean
	public PostRepository postRepositoryMock(){
		PostRepository postRepositoryMock = Mockito.mock(PostRepository.class);
		List<PostModel> postListMock = TestUtil.buildPostModelMockList();
		when(postRepositoryMock.findByAuthorId(eq(new ObjectId("5e79f485f28eb315e8dabd7c")))).thenReturn(postListMock);

		return postRepositoryMock;
	}

	@Primary
	@Bean
	public PostRetrievalService postRetrievalService(){
		return new PostRetrievalService(postRepositoryMock());
	}


}
