package com.andrea;

import com.andrea.dto.PostDto;
import com.andrea.model.PostModel;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtil {

	public static List<PostModel> buildPostModelMockList(){
		List<PostModel> postListMock = new ArrayList<>();
		postListMock.add(new PostModel());
		postListMock.get(0).setTitle("title");
		postListMock.get(0).setId(new ObjectId());
		postListMock.get(0).setAuthorId(new ObjectId("5e79f485f28eb315e8dabd7c"));
		postListMock.get(0).setBody("body");
		return postListMock;
	}


	public static void assertPostDtoListEqualsPostModelList(List<PostDto> postDtoList, List<PostModel> postModelList){
		assertEquals(postModelList.size(), postDtoList.size());
		assertEquals(postModelList.get(0).getAuthorId().toString(), postDtoList.get(0).getAuthorId());
		assertEquals(postModelList.get(0).getTitle(), postDtoList.get(0).getTitle());
		assertEquals(postModelList.get(0).getId().toString(), postDtoList.get(0).getId());
		assertEquals(postModelList.get(0).getBody(), postDtoList.get(0).getBody());
	}
}
