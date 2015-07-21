package com.nakedgardener.application.recentblogpost;

import com.nakedgardener.application.blogpost.BlogPostRepository;
import com.nakedgardener.application.domain.BlogPost;
import com.nakedgardener.application.domain.BlogPosts;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.nakedgardener.application.domain.BlogPosts.blogPostsBuilder;
import static com.nakedgardener.application.domain.BlogPosts.emptyBlogPosts;
import static java.time.LocalDateTime.now;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.ok;

@Component
public class RecentBlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final Logger applicationErrorLog;

    @Autowired
    public RecentBlogPostService(BlogPostRepository blogPostRepository, Logger applicationErrorLog) {
        this.blogPostRepository = blogPostRepository;
        this.applicationErrorLog = applicationErrorLog;
    }

    public ResponseEntity<BlogPosts> recentBlogPosts(int page, int pageSize) {
        try {
            Pageable pageable = new PageRequest(page, pageSize, DESC, "postDate");
            List<BlogPost> blogPosts = blogPostRepository.findByPostDateBefore(now(), pageable);
            return ok(blogPostsBuilder()
                    .blogPosts(blogPosts)
                    .build()
            );
        }
        catch(Exception e) {
            applicationErrorLog.error("An error has occurred in the RecentBlogPostService", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(emptyBlogPosts());
        }
    }
}
