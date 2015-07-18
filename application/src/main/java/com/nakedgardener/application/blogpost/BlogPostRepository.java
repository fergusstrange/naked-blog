package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogPostRepository extends MongoRepository<BlogPost, String>, BlogPostRepositoryCustom {
    BlogPost findByBlogPostSlug(String blogPostSlug);
    List<BlogPost> findByPostDateBefore(LocalDateTime date, Pageable pageable);
}
