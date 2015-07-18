package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Component
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug) {
        try {
            BlogPost blogPost = blogPostRepository.findByBlogPostSlug(blogPostSlug);
            return blogPost != null ?
                    new ResponseEntity<>(blogPost, OK) :
                    new ResponseEntity<>(NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
