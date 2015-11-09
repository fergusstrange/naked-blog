package com.nakedgardener.web.controller;

import com.nakedgardener.application.blogpostslug.BlogPostService;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BlogPostSlugController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostSlugController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @RequestMapping(method = GET, value = "/blog-post/_blogPostSlug/{blogPostSlug}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> retrieveBlogPost(@PathVariable final String blogPostSlug) {
        return blogPostService.findByBlogPostSlug(blogPostSlug);
    }
}
