package com.idev.blog.mapper;

import com.idev.blog.dto.PostDto;
import com.idev.blog.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {


  PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

  PostDto toPostDto(Post post);

  Post toPostEntity(PostDto postDto);
}
