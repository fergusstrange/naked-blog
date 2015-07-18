package com.nakedgardener.application.domain;

import java.util.ArrayList;
import java.util.List;

public class BlogPosts {

    private final List<BlogPost> blogPosts;

    private BlogPosts(BlogPostsBuilder blogPostsBuilder) {
        this.blogPosts = blogPostsBuilder.blogPosts;
    }

    public static BlogPostsBuilder blogPostsBuilder() {
        return new BlogPostsBuilder();
    }

    public static BlogPosts emptyBlogPosts() {
        return blogPostsBuilder().build();
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public static class BlogPostsBuilder {

        public List<BlogPost> blogPosts = new ArrayList<>();

        public BlogPostsBuilder blogPosts(List<BlogPost> blogPostΩ) {
            this.blogPosts.addAll(blogPosts);
            return this;
        }

        public BlogPosts build() {
            return new BlogPosts(this);
        }
    }
}
