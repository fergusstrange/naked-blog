package com.nakedgardener.application.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class BlogPost {

    @Id
    private String id;
    private Date postDate;
    private String blogPostSlug;
    private String title;
    private String post;

    public String getId() {
        return id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getBlogPostSlug() {
        return blogPostSlug;
    }

    public String getTitle() {
        return title;
    }

    public String getPost() {
        return post;
    }
}
