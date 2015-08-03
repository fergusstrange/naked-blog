package com.nakedgardener.cdc;

import com.nakedgardener.application.blogpost.BlogPostService;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("stubbed")
public class BlogPostServiceStub implements BlogPostService {

    @Override
    public ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug) {
        return ResponseEntity.ok(
                new BlogPost(
                        "55ac30b0936d190ae717e317",
                        LocalDateTime.of(2014, 2, 2, 1, 9),
                        blogPostSlug,
                        "A Test Blog",
                        "Some content in the blog!"
                )
        );
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        return new BlogPost();
    }
}