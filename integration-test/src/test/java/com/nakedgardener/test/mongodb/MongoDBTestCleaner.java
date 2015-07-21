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
public class MongoDBTestCleaner extends AbstractMongoEventListener<BlogPost> {

    private final Boolean mutex = false;
    private final ThreadLocal<Set<BlogPost>> blogPostThreadLocal = new ThreadLocal<>();
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public MongoDBTestCleaner(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
        this.blogPostThreadLocal.set(new HashSet<>());
    }

    @Override
    public void onAfterSave(BlogPost source, DBObject dbo) {
        synchronized (mutex) {
            blogPostThreadLocal.get().add(source);
        }
        super.onAfterSave(source, dbo);
    }

    public void cleanUpSavedEntities() {
        blogPostThreadLocal.get().forEach(blogPost -> blogPostRepository.delete(blogPost.getId()));
    }
}
