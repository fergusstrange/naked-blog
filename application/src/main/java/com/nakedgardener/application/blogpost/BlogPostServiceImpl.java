package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Component
@Profile("!stubbed")
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final Logger logger;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository, Logger logger) {
        this.blogPostRepository = blogPostRepository;
        this.logger = logger;
    }

    @Override
    public ResponseEntity<BlogPost> findByBlogPostSlug(String blogPostSlug) {
        try {
            BlogPost blogPost = blogPostRepository.findByBlogPostSlug(blogPostSlug);
            return blogPost != null ?
                    new ResponseEntity<>(blogPost, OK) :
                    new ResponseEntity<>(NOT_FOUND);
        }
        catch (Exception e) {
            logger.error("Exception has been thrown by BlogPostService", e);
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
