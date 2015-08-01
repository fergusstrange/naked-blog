package com.nakedgardener.cdc;

import com.nakedgardener.application.blogpost.BlogPostService;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Profile("stubbed")
public class BlogPostServiceStub implements BlogPostService {

    @Override
    public ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug) {
        return ResponseEntity.ok(new BlogPost());
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        return new BlogPost();
    }
}
