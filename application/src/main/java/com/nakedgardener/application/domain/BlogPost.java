package com.nakedgardener.application.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BlogPost {

    @Id
    private String id;
    private LocalDateTime postDate;
    private String blogPostSlug;
    private String title;
    private String post;

    public BlogPost() {
    }

    public BlogPost(String id, LocalDateTime postDate, String blogPostSlug, String title, String post) {
        this.id = id;
        this.postDate = postDate;
        this.blogPostSlug = blogPostSlug;
        this.title = title;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getPostDate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BlogPost blogPost = (BlogPost) o;

        return new EqualsBuilder()
                .append(id, blogPost.id)
                .append(postDate, blogPost.postDate)
                .append(blogPostSlug, blogPost.blogPostSlug)
                .append(title, blogPost.title)
                .append(post, blogPost.post)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(postDate)
                .append(blogPostSlug)
                .append(title)
                .append(post)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id='" + id + '\'' +
                ", postDate=" + postDate +
                ", blogPostSlug='" + blogPostSlug + '\'' +
                ", title='" + title + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
