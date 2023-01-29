package com.idev.blog.controller;

import com.idev.blog.dto.PostDto;
import com.idev.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public String posts(Model model) {
    List<PostDto> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    model.addAttribute("title", "List Posts");
    return "/admin/posts";
  }

  @GetMapping("/posts/new")//estudiantes/nuevo
  public String newPostForm(Model model) {
    PostDto postDto = new PostDto();
    model.addAttribute("post", postDto);
    model.addAttribute("title", "New Post");
    return "/admin/create_post";
  }

  @PostMapping("/posts")
  public String createPost(@ModelAttribute PostDto postDto) {
    postDto.setUrl(getUrl(postDto.getTitle()));
    //postDto.setStatus(true);
    postService.createPost(postDto);
    return "redirect:/admin/posts";
  }

  @GetMapping("/posts/{postId}/edit")
  public String editPostForm(@PathVariable(name = "postId") Long postId,
                             Model model) {
    PostDto postDto = postService.findPostById(postId);
    model.addAttribute("post", postDto);
    return "/admin/edit_post";
  }

  @PostMapping("/posts/{postId}")
  public String updatePost(@PathVariable("postId") Long postId,
                           @ModelAttribute("post") PostDto post,
                           BindingResult result,
                           Model model) {

    if (result.hasErrors()) {
      model.addAttribute("post", post);
      return "/admin/edit_post";
    }
    post.setIdPost(postId);
    post.setStatus(true);
    postService.updatePost(post);
    return "redirect:/admin/posts";
  }

  @GetMapping("/posts/{postId}/delete")
  public String deletePost(@PathVariable("postId") Long postId) {
    postService.deletePost(postId);
    return "redirect:/admin/posts";
  }

  @GetMapping("/posts/search")
  public String searchPosts(@RequestParam(name = "query") String query,
                            Model model) {
    List<PostDto> posts = postService.searchPosts(query);
    model.addAttribute("posts", posts);
    return "admin/posts";
  }


  private static String getUrl(String postTitle) {
    String title = postTitle.trim().toLowerCase();
    String url = title.replaceAll("ñ", "n");
    url = url.replaceAll("[\\s,[^A-Za-z0-9]]", "-");
    return url;
  }
}




















