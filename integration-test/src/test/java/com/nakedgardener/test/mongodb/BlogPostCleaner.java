package com.nakedgardener.test.mongodb;

import com.mongodb.DBObject;
import com.nakedgardener.application.blogpost.BlogPostRepository;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BlogPostCleaner extends AbstractMongoEventListener<BlogPost> {

    private final ThreadLocal<Set<BlogPost>> blogPostThreadLocal = new ThreadLocal<>();
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostCleaner(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
        this.blogPostThreadLocal.set(new HashSet<>());
    }

    @Override
    public void onAfterSave(BlogPost source, DBObject dbo) {
        synchronized (this) {
            blogPostThreadLocal.get().add(source);
        }
        super.onAfterSave(source, dbo);
    }

    public void cleanUpSavedEntities() {
        blogPostThreadLocal.get().forEach(blogPost -> blogPostRepository.delete(blogPost.getId()));
    }
}
