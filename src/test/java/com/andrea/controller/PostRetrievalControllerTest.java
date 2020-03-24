package com.andrea.controller;

import com.andrea.dto.PostDto;
import com.andrea.service.IPostRetrievalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PostRetrievalControllerTest {

	@Mock
	IPostRetrievalService postRetrievalServiceMock;

	@InjectMocks
	PostRetrievalController postRetrievalController;

	List<PostDto> postListMock;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);

		postListMock = new ArrayList<>();
		postListMock.add(new PostDto());
		postListMock.get(0).setTitle("title");
		when(postRetrievalServiceMock.getPostListByAuthorId(eq("aaa"))).thenReturn(postListMock);
		when(postRetrievalServiceMock.getPostListByAuthorId(eq("bbb"))).thenReturn(new ArrayList<>());
	}


	@Test
	public void testConstructor() {
		PostRetrievalController postRetrievalController = new PostRetrievalController(postRetrievalServiceMock);
		assertEquals(postRetrievalServiceMock, postRetrievalController.postRetrievalService);
	}

	@Test
	void getPostListByAuthorId() {
		List<PostDto> postList = postRetrievalController.getPostListByAuthorId("aaa");
		verify(postRetrievalServiceMock, times(1)).getPostListByAuthorId(eq("aaa"));
		assertEquals(postListMock, postList);
	}

	@Test
	void getPostListByAuthorId_nullResponse() {
		List<PostDto> postList = postRetrievalController.getPostListByAuthorId("bbb");
		verify(postRetrievalServiceMock, times(1)).getPostListByAuthorId(eq("bbb"));
		assertEquals(0, postList.size());
	}
}