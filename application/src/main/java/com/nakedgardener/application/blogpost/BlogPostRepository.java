package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Profile("!stubbed")
public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
    BlogPost findByBlogPostSlug(String blogPostSlug);
    List<BlogPost> findByPostDateBefore(LocalDateTime date, Pageable pageable);
}
