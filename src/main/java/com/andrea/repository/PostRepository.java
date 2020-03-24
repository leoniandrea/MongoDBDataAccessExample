package com.andrea.repository;

import com.andrea.model.PostModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostModel, Long> {
	List<PostModel> findByAuthorId(ObjectId authorId);


}
