package com.nakedgardener.cdc;

import com.nakedgardener.application.blogpost.BlogPostRepository;
import com.nakedgardener.application.domain.BlogPost;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Profile("stubbed")
public class BlogPostRepositoryStub implements BlogPostRepository {

    @Override
    public BlogPost findByBlogPostSlug(String blogPostSlug) {
        return null;
    }

    @Override
    public List<BlogPost> findByPostDateBefore(LocalDateTime date, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BlogPost> S save(S entity) {
        return null;
    }

    @Override
    public BlogPost findOne(String s) {
        return null;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public <S extends BlogPost> List<S> save(Iterable<S> entites) {
        return null;
    }

    @Override
    public List<BlogPost> findAll() {
        return null;
    }

    @Override
    public Iterable<BlogPost> findAll(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(BlogPost entity) {

    }

    @Override
    public void delete(Iterable<? extends BlogPost> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<BlogPost> findAll(Sort sort) {
        return null;
    }

    @Override
    public <S extends BlogPost> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends BlogPost> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public Page<BlogPost> findAll(Pageable pageable) {
        return null;
    }
}
