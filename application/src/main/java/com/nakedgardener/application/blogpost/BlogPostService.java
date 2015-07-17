package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost findByBlogPostSlug(String blogPostSlug) {
        return blogPostRepository.findByBlogPostSlug(blogPostSlug);
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
