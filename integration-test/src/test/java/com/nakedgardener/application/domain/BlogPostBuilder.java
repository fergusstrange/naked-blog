package com.nakedgardener.application.domain;

import java.time.LocalDateTime;

public class BlogPostBuilder {

    private String title;
    private String blogPostSlug;
    private String id;
    private LocalDateTime postDate;
    private String post;

    private BlogPostBuilder(){}

    public static BlogPostBuilder blogPostBuilder() {
        return new BlogPostBuilder();
    }

    public BlogPostBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BlogPostBuilder blogPostSlug(String blogPostSlug) {
        this.blogPostSlug = blogPostSlug;
        return this;
    }

    public BlogPostBuilder id(String id) {
        this.id = id;
        return this;
    }

    public BlogPostBuilder postDate(LocalDateTime postDate) {
        this.postDate = postDate;
        return this;
    }

    public BlogPostBuilder post(String post) {
        this.post = post;
        return this;
    }

    public BlogPost build() {
        return new BlogPost(id, postDate, blogPostSlug, title, post);
    }
}
