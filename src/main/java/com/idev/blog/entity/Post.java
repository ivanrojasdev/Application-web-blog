package com.idev.blog.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "posts")
public class Post {
  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPost")
  @SequenceGenerator(name = "seqPost", sequenceName = "seq_post", allocationSize = 1)
  private Long idPost;

  @Column(length = 100, nullable = false)
  private String title;

  @Column(length = 150)
  private String url;

  @Column(columnDefinition = "text", nullable = false)
  private String content;

  @Column(nullable = false)
  private String description;

  @Column(columnDefinition = "boolean default true", nullable = false, insertable = false)
  //@Basic(optional = true)
  private Boolean status;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updatedAt;
}
//@Column(insertable = true, updatable = true)


//@Column(columnDefinition = "timestamp default current_timestamp", updatable = true, insertable = false, nullable = false) NO SALE