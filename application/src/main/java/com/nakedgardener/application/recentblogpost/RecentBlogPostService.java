package com.nakedgardener.application.recentblogpost;

import com.nakedgardener.application.domain.BlogPosts;
import org.springframework.http.ResponseEntity;

public interface RecentBlogPostService {
    ResponseEntity<BlogPosts> recentBlogPosts(int page, int pageSize);
}
