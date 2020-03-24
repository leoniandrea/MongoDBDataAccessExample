package com.andrea.controller;

import com.andrea.dto.PostDto;
import com.andrea.service.IPostRetrievalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


class PostRetrievalControllerIntegrationTest {

	@Mock
	IPostRetrievalService postRetrievalServiceMock;

	@InjectMocks
	PostRetrievalController postRetrievalController;

	MockMvc mockMvc;

	List<PostDto> postListMock;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(postRetrievalController).build();

		postListMock = new ArrayList<>();
		postListMock.add(new PostDto());
		postListMock.get(0).setTitle("title");
		when(postRetrievalServiceMock.getPostListByAuthorId(eq("aaa"))).thenReturn(postListMock);
		when(postRetrievalServiceMock.getPostListByAuthorId(eq("bbb"))).thenReturn(new ArrayList<>());
	}


	@Test
	public void receiveCorrectCall() throws Exception {
		MockHttpServletRequestBuilder getRequestBuilder = get("/posts?authorId=aaa").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(getRequestBuilder).andReturn();

		List<PostDto> postList = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<PostDto>>() {});
		verify(postRetrievalServiceMock, times(1)).getPostListByAuthorId(eq("aaa"));
		assertEquals(postListMock, postList);
	}

}