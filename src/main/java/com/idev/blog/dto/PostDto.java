package com.idev.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
  private Long idPost;
  private String title;
  private String url;
  private String content;
  private String description;
  private Boolean status;
  private LocalDateTime createdAt;
  private LocalDateTime updateAt;
}
