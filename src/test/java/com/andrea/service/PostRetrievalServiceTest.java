package com.andrea.service;

import com.andrea.dto.PostDto;
import com.andrea.model.PostModel;
import com.andrea.repository.PostRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.andrea.TestUtil.assertPostDtoListEqualsPostModelList;
import static com.andrea.TestUtil.buildPostModelMockList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PostRetrievalServiceTest {

	@Mock
	PostRepository postRepositoryMock;

	@InjectMocks
	PostRetrievalService postRetrievalService;

	List<PostModel> postListMock = buildPostModelMockList();


	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		when(postRepositoryMock.findByAuthorId(eq(new ObjectId("5e79f485f28eb315e8dabd7c")))).thenReturn(postListMock);
	}

	@Test
	public void testConstructor(){
		PostRetrievalService postRetrievalService = new PostRetrievalService(postRepositoryMock);
		assertEquals(postRepositoryMock, postRetrievalService.postRepository);
	}

	@Test
	void getPostListByAuthorId() {
		List<PostDto> postList = postRetrievalService.getPostListByAuthorId("5e79f485f28eb315e8dabd7c");

		verify(postRepositoryMock, times(1)).findByAuthorId(eq(new ObjectId("5e79f485f28eb315e8dabd7c")));

		assertPostDtoListEqualsPostModelList(postList, postListMock);
	}
}