package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.http.ResponseEntity;

public interface BlogPostService {
    ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug);
    BlogPost save(BlogPost blogPost);
}
