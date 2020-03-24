package com.andrea.mapper;

import com.andrea.dto.PostDto;
import com.andrea.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostModelToDtoMapper {
	public static PostDto map(PostModel postModel){
		if (postModel == null) {
			return null;
		}
		PostDto postDto = new PostDto();
		postDto.setId(postModel.getId().toString());
		postDto.setAuthorId(postModel.getAuthorId().toString());
		postDto.setTitle(postModel.getTitle());
		postDto.setBody(postModel.getBody());
		return postDto;
	}

	public static List<PostDto> mapList(List<PostModel> postModelList){
		List<PostDto> postDtoList = new ArrayList<>();
		if (postModelList == null) {
			return postDtoList;
		}

		for (PostModel postModel : postModelList) {
			postDtoList.add(map(postModel));
		}
		return postDtoList;
	}

}
