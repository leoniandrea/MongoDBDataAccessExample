package com.andrea.controller;

import com.andrea.Application;
import com.andrea.TestUtil;
import com.andrea.configuration.IntegrationTestConfiguration;
import com.andrea.dto.PostDto;
import com.andrea.repository.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {Application.class, IntegrationTestConfiguration.class})
@TestPropertySource(locations = "classpath:application.properties")
public class PostRetrievalControllerEndToEndTest {

	@Autowired
	PostRepository postRepositoryMock;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void correctCall() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(headers);

		String url = "http://localhost:8000/posts?authorId=5e79f485f28eb315e8dabd7c";
		String stringResponse = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
		List<PostDto> postDtoList = new ObjectMapper().readValue(stringResponse, new TypeReference<List<PostDto>>() {});

		TestUtil.assertPostDtoListEqualsPostModelList(postDtoList, postRepositoryMock.findByAuthorId(new ObjectId("5e79f485f28eb315e8dabd7c")));
	}

}
