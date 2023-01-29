package com.idev.blog.repository;

import com.idev.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("SELECT p FROM Post p where " + " p.title like CONCAT('%',:query, '%') OR " +
          "p.description LIKE CONCAT ('%', :query, '%')")
  List<Post> searchPosts(String query);

}
