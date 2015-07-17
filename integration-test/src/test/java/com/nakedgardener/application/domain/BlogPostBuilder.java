package com.nakedgardener.application.domain;

public class BlogPostBuilder {

    private String title;
    private String blogPostSlug;
    private String id;

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

    public BlogPost build() {
        return new BlogPost(id, null, blogPostSlug, title, null);
    }
}
