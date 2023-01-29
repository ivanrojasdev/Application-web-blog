package com.idev.blog.service.impl;

import com.idev.blog.dto.PostDto;
import com.idev.blog.entity.Post;
import com.idev.blog.mapper.PostMapper;
import com.idev.blog.repository.PostRepository;
import com.idev.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper = PostMapper.INSTANCE;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<PostDto> getAllPosts() {
    List<Post> post = postRepository.findAll();
    return post.stream()
            .map(postMapper::toPostDto)
            .collect(Collectors.toList());
  }

  @Override
  public void createPost(PostDto postDto) {
    Post post = postMapper.toPostEntity(postDto);
    postRepository.save(post);
  }

  @Override
  public PostDto findPostById(Long postId) {
    Post post = postRepository.findById(postId).get();
    return postMapper.toPostDto(post);
  }

  @Override
  public void updatePost(PostDto postDto) {
    Post post = postMapper.toPostEntity(postDto);
    postRepository.save(post);
  }

  @Override
  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }

  @Override
  public List<PostDto> searchPosts(String query) {
    List<Post> posts = postRepository.searchPosts(query);
    return posts.stream()
            .map(postMapper::toPostDto)// .map(p -> postMapper.toPostDto(p))
            .collect(Collectors.toList());

   /* return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
            .collect(Collectors.toList());*/
  }
}
