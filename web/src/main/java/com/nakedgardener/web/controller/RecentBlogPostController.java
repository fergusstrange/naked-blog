package com.nakedgardener.web.controller;

import com.nakedgardener.application.domain.BlogPosts;
import com.nakedgardener.application.recentblogpost.RecentBlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RecentBlogPostController {

    private final RecentBlogPostService recentBlogPostService;

    @Autowired
    public RecentBlogPostController(RecentBlogPostService recentBlogPostService) {
        this.recentBlogPostService = recentBlogPostService;
    }

    @RequestMapping(method = GET, value = "/blog-post/_recent", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPosts> recentBlogPosts(@RequestParam final int page, @RequestParam final int pageSize) {
        return recentBlogPostService.recentBlogPosts(page, pageSize);
    }
}
