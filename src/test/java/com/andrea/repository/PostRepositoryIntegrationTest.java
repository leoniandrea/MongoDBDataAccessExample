package com.andrea.repository;

import com.andrea.Application;
import com.andrea.model.PostModel;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Disabled("Disabled unless an actual mongoDB is running")
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.properties")
class PostRepositoryIntegrationTest {
	@Autowired
	PostRepository postRepository;

	@Test
	void findByAuthor() {
		List<PostModel> books = postRepository.findByAuthorId(new ObjectId("5e79f485f28eb315e8dabd7c"));
		assertEquals("Titolo post", books.get(0).getTitle());
	}

	@Test
	void findByAuthorNotExistent() {
		List<PostModel> books = postRepository.findByAuthorId(new ObjectId());
		assertTrue(books.isEmpty());
	}
}