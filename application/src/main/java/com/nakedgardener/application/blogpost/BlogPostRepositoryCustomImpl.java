package com.nakedgardener.application.blogpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BlogPostRepositoryCustomImpl implements BlogPostRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public BlogPostRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
