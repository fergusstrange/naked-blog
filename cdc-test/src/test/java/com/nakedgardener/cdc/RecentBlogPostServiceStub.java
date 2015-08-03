package com.nakedgardener.cdc;

import com.nakedgardener.application.domain.BlogPosts;
import com.nakedgardener.application.recentblogpost.RecentBlogPostService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.ResponseEntity.ok;

@Component
@Profile("stubbed")
public class RecentBlogPostServiceStub implements RecentBlogPostService {

    @Override
    public ResponseEntity<BlogPosts> recentBlogPosts(int page, int pageSize) {
        return ok(BlogPosts.emptyBlogPosts());
    }
}
