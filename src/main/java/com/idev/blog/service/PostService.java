package com.idev.blog.service;

import com.idev.blog.dto.PostDto;

import java.util.List;

public interface PostService {

  List<PostDto> getAllPosts();

  void createPost(PostDto postDto);

  PostDto findPostById(Long postId);

  void updatePost(PostDto postDto);

  void deletePost(Long post);

  List<PostDto> searchPosts(String query);

}
