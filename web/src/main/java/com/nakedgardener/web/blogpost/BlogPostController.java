package com.nakedgardener.web.blogpost;

import com.nakedgardener.application.blogpost.BlogPostService;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @RequestMapping(method = GET, value = "/blog-post/_blogPostSlug/${blogPostSlug}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> retrieveBlogPost(@PathVariable final String blogPostSlug) {
        return blogPostService.findByBlogPostSlug(blogPostSlug);
    }

    @RequestMapping(method = PUT, value = "/blog-post",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BlogPost saveBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.save(blogPost);
    }
}
