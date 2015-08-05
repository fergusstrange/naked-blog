package com.nakedgardener.application.blogpostslug;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.http.ResponseEntity;

public interface BlogPostService {
    ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug);
}
