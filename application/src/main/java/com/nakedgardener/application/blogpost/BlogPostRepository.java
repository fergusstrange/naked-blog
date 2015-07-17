package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
    BlogPost findByBlogPostSlug(String blogPostSlug);
}
